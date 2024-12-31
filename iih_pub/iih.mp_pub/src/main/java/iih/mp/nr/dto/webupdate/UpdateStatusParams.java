package iih.mp.nr.dto.webupdate;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 修改状态入参
 * @Description:
 * @author: huang_junhao@founder.com.cn
 * @version：2019年5月22日 下午3:13:23 创建
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateStatusParams implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UpdateStatusParam[] param;

	public UpdateStatusParam[] getPramList() {
		return param;
	}

	public void setPramList(UpdateStatusParam[] param) {
		this.param = param;
	}

}
