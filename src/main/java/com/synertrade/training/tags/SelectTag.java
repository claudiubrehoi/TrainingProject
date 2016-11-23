package com.synertrade.training.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.synertrade.training.vo.BaseVO;

public class SelectTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException{
		
		JspWriter out = getJspContext().getOut();
		
		out.println(getTagHtml());
	}
	
	public String drawHtml(List<? extends BaseVO> objects, String selectName, int selectedId, int selectedParentId) {
		
		String response = "";
		
		if(objects.size() > 0) {
			response = "<select name='" + selectName + "'>\n";
		}
		
		for(BaseVO obj : objects) {
			response = response.concat("<option value='" + obj.getId() + "'");
			if(obj.getId() == selectedId){
				response = response.concat(" selected");
			} 
			response = response.concat(">" + obj.getName() + "</option>\n");
		}
		
		response = response.concat("</select>\n");
		
		return response;
	}
	
	public String getTagHtml() {
		return null;
	}
}
