package iih.ci.ord.s.external.outqry.bp;

import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import iih.ci.ord.external.outqry.d.OrdQueryParamDTO;
import iih.ci.ord.external.outqry.d.PatientInfoDTO;
import xap.mw.core.data.BizException;

public class OpCiOutQryBP {
	
	public String OpCiOutQryBP(OrdQueryParamDTO param) throws BizException {
		Document document = CiOutQueryUtils.getDocumentObj();
		// 3、实例化Title，返回title节点
		HashMap<String, Element> mapEle = new HashMap<String, Element>();
		Element root = CiOutQueryUtils.initTitle(document, mapEle);
		this.validateParam(param);		
		PatientInfoDTO[] patinfo=new OpCiOutQueryOrdInfoBP().exe(param);

//		if(qrylist!=null&&qrylist.size()>0) {
			return CiOutQueryUtils.conversionXml_new2(document,root,patinfo);
//		}
//		return null;
	}
	
	private void validateParam(OrdQueryParamDTO param) throws BizException {
		if(param==null)throw new BizException("参数为空！");
		if(CiOutQueryUtils.isStrEmpty(param.getCode_entp()))
			throw new BizException("就诊类型为空");
		if(CiOutQueryUtils.isStrEmpty(param.getCode_en())&&(CiOutQueryUtils.isStrEmpty(param.getCode_pat())))
			throw new BizException("就诊编码和患者编码不能同时为空");
	}
	

}
