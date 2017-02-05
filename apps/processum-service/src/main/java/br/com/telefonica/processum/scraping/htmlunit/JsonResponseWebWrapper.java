package br.com.telefonica.processum.scraping.htmlunit;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.util.WebConnectionWrapper;

public class JsonResponseWebWrapper extends WebConnectionWrapper {

	public JsonResponseWebWrapper(WebClient webClient){
        super(webClient);           
    }

    String jsonResponse;

    @Override
    public WebResponse getResponse(WebRequest request) throws IOException {
		WebResponse response = super.getResponse(request);
		jsonResponse = response.getContentAsString();
		return response;
    }

    public String getJsonResponse() {
		return jsonResponse;
    }
}