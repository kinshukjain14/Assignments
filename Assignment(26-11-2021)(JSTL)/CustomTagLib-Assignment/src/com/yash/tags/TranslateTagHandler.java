package com.yash.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TranslateTagHandler extends BodyTagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String toCase;
	

	public String getToCase() {
		return toCase;
	}
	public void setToCase(String toCase) {
		this.toCase = toCase;
	}


	@Override
	public int doAfterBody() throws JspException {
		BodyContent content = getBodyContent();
		String string = content.getString();
		if(toCase.equalsIgnoreCase("lower")) {
			string = string.toLowerCase();
		}
		else if(toCase.equalsIgnoreCase("upper")){
			string = string.toUpperCase();
		}
		JspWriter writer = content.getEnclosingWriter();
			try {
				writer.write(string);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return EVAL_PAGE;
	}
}
