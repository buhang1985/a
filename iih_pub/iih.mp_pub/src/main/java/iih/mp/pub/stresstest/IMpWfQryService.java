package iih.mp.pub.stresstest;

import iih.ci.ord.labordernoview.d.LabOrderNoView;
import iih.ci.ord.obsordernoview.d.ObsOrderNoView;
import iih.ci.ord.rptpathgynoview.d.RptpathgynoView;

import java.net.BindException;

import xap.mw.core.data.BizException;

public interface IMpWfQryService {

	/**
	 * 获取检验申请单号
	 * 
	 * @return
	 * @throws BindException
	 */
	public LabOrderNoView getLabOrderNO(String id_or) throws BizException;

	/**
	 * 获取检查申请单号
	 * 
	 * @return
	 * @throws BindException
	 */
	public ObsOrderNoView[] getObsOrderNO(String id_or) throws BizException;

	/**
	 * 获取病例申请单号
	 * 
	 * @return
	 * @throws BindException
	 */
	public RptpathgynoView getRptpathgyNO(String id_or) throws BizException;

}
