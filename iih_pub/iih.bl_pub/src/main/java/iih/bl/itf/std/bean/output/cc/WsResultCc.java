package iih.bl.itf.std.bean.output.cc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.output.WsResult;

/**
 * 结账出参
 * 
 * @author shaokx 2020/05/13
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultCc extends WsResult{

	private static final long serialVersionUID = 1L;
	
}
