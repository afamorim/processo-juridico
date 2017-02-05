var Config = {
	WORKFLOW_PATH: 'workflow-geral.json',
	WORKFLOW_PROCESSAMENTO_REQUISICAO_PATH: 'workflow-processamento-requisicao.json',
	WORKFLOW_PROCESSAMENTO_ARQUIVO_PATH: 'workflow-processamento-arquivo.json'
};

$(function(){
	
	var $listItems = $('#listStatus>li');
	var $totalItems = $('#totalItems');
	var $cmbTipo = $('#cmbTipo');

	$cmbTipo.change(function(){
		var _val = $(this).val();
		var _itemsCount = 0;

		$listItems.removeClass('hide-type').removeClass('filter-type');

		if(_val != 0){
			$listItems.each(function(){
				var $this = $(this);
				if($this.data('type')==_val){
					$this.addClass('filter-type');
					_itemsCount++;
				} else {
					$this.addClass('hide-type');
				}
				
			});
		} else {
			_itemsCount = $listItems.size();
		}

		$totalItems.text(_itemsCount);

	});

	//load type
	var _urlParams = Utils.getUrlParams();
	if(_urlParams.s!=null){
		var $option = $cmbTipo.find('option[value="'+_urlParams.s+'"]');
		if($option.size()>0){
			$cmbTipo.find('option:selected').removeProp('selected');
			$option.prop('selected',true);
		}

	}

	$cmbTipo.trigger('change');

	//filter requisicoes/arquivos
	$('[data-role="tab-buttons"] > button').click(function(){
		var $this = $(this);
		if(!$this.hasClass('state-info')){
			var _path = $(this).data('path');
			if(_path!=null && Config[_path]!=null){
				fillWorkflow(Config[_path]);

				$this.removeClass('state-disabled').siblings().removeClass('state-info');
				$this.addClass('state-info');
			}
		}
	});

	//get initial workflow
	fillWorkflow(Config.WORKFLOW_PATH);
});

function fillWorkflow(path){

	$.getJSON(path, function(data) {

		if(data != null && $.isArray(data)){
			
			for(var i=0; i<data.length;i++){
				
				var _item = data[i];
				var $step = $('#'+_item.name);
				var _val = _item.total;
	
				if($step.size()>0 && _val!=null){
					
					if(_val!=null){
						var $totalContainer = $step.find('[data-role="step-title"]');
							$totalContainer = ($totalContainer.size()>0)?$totalContainer:$step;
						$totalContainer.find('.total').text(_val);
					}
					
					if(_item.children!=null && $.isArray(_item.children)){
						for(var n=0; n<_item.children.length;n++){
							var _child = _item.children[n];
							$step.find('[data-role="'+_child.name+'"]').find('.total').text(_child.total);
						}
					}
	
				}
			
			}

		}

	}).fail(function(){
		//alert('Ocorreu um erro ao obter os dados do workflow.');
	});

}

var Utils = {
	scrollTop: function(){
		$('html,body').animate({scrollTop:'0px'});
	},
	backPage: function(){
		history.back();
	},
	getUrlParams: function () {
	  var query_string = {};
	  var query = window.location.search.substring(1);
	  var vars = query.split("&");
	  for (var i=0;i<vars.length;i++) {
	    var pair = vars[i].split("=");
	        // If first entry with this name
	    if (typeof query_string[pair[0]] === "undefined") {
	      query_string[pair[0]] = decodeURIComponent(pair[1]);
	        // If second entry with this name
	    } else if (typeof query_string[pair[0]] === "string") {
	      var arr = [ query_string[pair[0]],decodeURIComponent(pair[1]) ];
	      query_string[pair[0]] = arr;
	        // If third or later entry with this name
	    } else {
	      query_string[pair[0]].push(decodeURIComponent(pair[1]));
	    }
	  } 
	    return query_string;
	}
};