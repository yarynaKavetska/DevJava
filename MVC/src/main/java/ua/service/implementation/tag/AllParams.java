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

public class AllParams extends SimpleTagSupport{

	private final StringWriter sw = new StringWriter();
	private final static String amper = "&";
	private final static String quest = "?";
	private final static String equal = "=";
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		Map<String, String[]> map = request.getParameterMap();
		boolean isFirst = true;
		for(Entry<String, String[]> entry : map.entrySet()){
			for(String value : entry.getValue()){
				if(isFirst){
					sw.append(quest);
					isFirst = false;
				}else{
					sw.append(amper);
				}
				sw.append(entry.getKey());
				sw.append(equal);
				sw.append(value);
			}
		}
		out.println(sw.toString());
	}
}
