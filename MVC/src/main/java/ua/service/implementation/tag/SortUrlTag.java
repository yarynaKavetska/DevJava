package ua.service.implementation.tag;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SortUrlTag extends SimpleTagSupport {

	private final StringWriter sw = new StringWriter();
	private final static String amper = "&";
	private final static String quest = "?";
	private final static String equal = "=";
	private String paramValue = "";
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		sw.append(quest);
		sw.append("sort");
		sw.append(equal);
		sw.append(paramValue);
		Map<String, String[]> map = request.getParameterMap();
		for(Entry<String, String[]> entry : map.entrySet()){
			for(String value : entry.getValue()){
				if(!entry.getKey().equals("sort")){
					sw.append(amper);
					sw.append(entry.getKey());
					sw.append(equal);
					sw.append(value);
				}
			}
		}
		out.println(sw.toString());
	}
	
	public void setParamValue(String paramValue){
		this.paramValue = paramValue;
	}
}
