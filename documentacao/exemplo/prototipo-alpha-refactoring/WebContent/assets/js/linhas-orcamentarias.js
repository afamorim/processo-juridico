/* project specific js */
var datatableLinhas;

$(function(){
	
	datatableLinhas = setupSubtable('gridLinhas');
	
});

function callDynamicCommand(remoteCommandName,eventData){
	var fn = window[remoteCommandName+eventData.params[0].value];
	
	if(fn!=null && typeof fn !== "undefined"){
		fn();
	}
}

function setupSubtable(widgetVar){

	datatable = PF(widgetVar);
	
	datatable.___oldInit = datatable.init;
	datatable.init = function(){
		this.___oldInit.apply(this,arguments);
	}
	
	datatable._oldBindCheckboxEvents = datatable.bindCheckboxEvents;
	datatable.bindCheckboxEvents = function(){
		
		this.checkAllToggler = datatable.thead.find("> tr > th.ui-selection-column .ui-chkbox > .ui-chkbox-box");
		this.checkAllToggler.parent().unwrap();
		this.tbody.find("> tr.ui-widget-content").addClass('ui-datatable-selectable');
		
		//do colspan manually
		datatable.tbody.find('td.cellcolspan').each(function(){
		     var colspan = parseInt($(this).attr('class').split('colspan-')[1]);
		     var index = $(this).index();
		     $(this).attr('colspan',colspan);
		     $(this).parent().find('>td').slice(index+1,colspan+index).remove();
		     $(this).parent().addClass('dynamic-colspaned');
		});
		
		//setup row index and row key manually
		datatable.tbody.find("> tr.ui-widget-content > td.ui-selection-column > .ui-chkbox").each(function(){
			
			var $row = $(this).parents('tr:first');
			var rowIndex = $row.index();
			
			$row.attr('data-ri', rowIndex);
			$row.attr('data-rk', $(this).data('rowkey'));
			
			if($(this).data('selected')){
				datatable.selectRow(rowIndex);
			} else {
				datatable.unselectRow(rowIndex);
			}
		});
		
		this._oldBindCheckboxEvents.apply(this, arguments);
		
		datatable.updateHeaderCheckbox();
	};

	datatable.bindCheckboxEvents();
	
	return datatable;
}