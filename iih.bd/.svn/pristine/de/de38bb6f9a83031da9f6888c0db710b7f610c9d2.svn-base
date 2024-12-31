package iih.bd.fc.que.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueCudService;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteCudService;
import iih.bd.fc.quesite.i.IQuesiteRService;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 生成药房队列BP
 * 
 * @author Administrator
 *
 */
public class GenQueBP {

	/**
	 * 生成药房队列
	 * 
	 * @throws BizException
	 */
	public QueDO[] genDsQue() throws BizException {
		// 1.把药房科室生成队列
		this.createQue();
		// 2.把已经删除的科室对应的队列对应删除
		QueDO[] queDOs = this.delQueWhenDepDel();
		// 3.删除已删除的队列对应的工作站
		if (!ArrayUtil.isEmptyNoNull(queDOs)) {
			this.delSiteWhenDelQue(queDOs);
		}
		return null;
	}

	/**
	 * 把药房科室生成队列
	 * 
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void createQue() throws BizException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT DEP.CODE,DEP.NAME,DEP.NAME AS DES,DEP.ID_DEP ");
		sb.append("FROM BD_DEP DEP ");
		sb.append("WHERE DEP.ID_DEP NOT IN (SELECT BQ.ID_DEP FROM BD_QUE BQ WHERE BQ.SD_QUETP = ? AND " + EnvContextUtil.processEnvContext("", new QueDO(), "BQ") +" ) ");
		sb.append("AND DEP.SD_DEPTTP LIKE '").append(IBdResDictCodeConst.SD_DEPTTP_PHARMACY).append("%' ");
		sb.append("AND " + EnvContextUtil.processEnvContext("", new DeptDO(), "DEP") + " ");
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_QUETP_PHARMACY);// 药房队列
		List<QueDO> list = (List<QueDO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(QueDO.class));
		if (!ListUtil.isEmpty(list)) {
			for (QueDO que : list) {
				que.setSd_mode(IBdFcDictCodeConst.SD_MODEL_PHA_NO);
				que.setId_mode(IBdFcDictCodeConst.ID_MODEL_PHA_NO);
				que.setFg_active(FBoolean.TRUE);
				que.setSd_quetp(IBdFcDictCodeConst.SD_QUETP_PHARMACY);
				que.setId_quetp(IBdFcDictCodeConst.ID_QUETP_PHARMACY);
				que.setId_grp(Context.get().getGroupId());
				que.setId_org(Context.get().getOrgId());
				que.setPycode(CnToPy.getPyFirstCode(que.getName()));
				que.setWbcode(CnToWB.getWBCode(que.getName()));
				que.setMnecode(que.getCode());
				que.setStatus(DOStatus.NEW);
			}
			IQueCudService queCudService = ServiceFinder
					.find(IQueCudService.class);
			queCudService.save(list.toArray(new QueDO[0]));
		}
	}

	/**
	 * 把已经删除的科室对应的队列对应删除
	 * 
	 * @return 删除的队列
	 * @throws BizException
	 */
	private QueDO[] delQueWhenDepDel() throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT BQ.* ");
		sb.append("FROM BD_QUE BQ ");
		sb.append("WHERE BQ.ID_DEP NOT IN ( ");
		sb.append("SELECT DEP.ID_DEP FROM BD_DEP DEP ");
		sb.append("WHERE DEP.SD_DEPTTP LIKE ? ");
		sb.append("AND " + EnvContextUtil.processEnvContext("", new DeptDO(), "DEP") + " ");
		sb.append(" ) ");
		sb.append("AND BQ.SD_QUETP = ? ");
		sb.append("AND " + EnvContextUtil.processEnvContext("", new QueDO(), "BQ") + " ");
		SqlParam param = new SqlParam();
		param.addParam(IBdResDictCodeConst.SD_DEPTTP_PHARMACY + "%");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_PHARMACY);
		List<QueDO> list = (List<QueDO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(QueDO.class));
		QueDO[] ques = null;
		if (!ListUtil.isEmpty(list)) {
			ques = list.toArray(new QueDO[0]);
			IQueCudService queCudService = ServiceFinder.find(IQueCudService.class);
			queCudService.delete(ques);
		}
		return ques;
	}

	/**
	 * 删除已删除的队列对应的工作站
	 * 
	 * @param queDOs
	 * @throws BizException
	 */
	private void delSiteWhenDelQue(QueDO[] queDOs) throws BizException {
		if (!ArrayUtil.isEmptyNoNull(queDOs)) {
			FArrayList list = new FArrayList();
			for(QueDO que : queDOs){
				if(!StringUtil.isEmptyWithTrim(que.getId_que())){
					list.add(que.getId_que());
				}
			}
			IQuesiteRService siteRService = ServiceFinder.find(IQuesiteRService.class);
			QueSiteDO[] queSiteDOs = siteRService.findByAttrValList(QueSiteDO.ID_QUE, list);
			if (!ArrayUtil.isEmptyNoNull(queSiteDOs)) {
				IQuesiteCudService siteCudService = ServiceFinder.find(IQuesiteCudService.class);
				siteCudService.delete(queSiteDOs);
			}
		}
	}
}
