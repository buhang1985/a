package iih.ci.mrqc.qcremindmsgdto.s.bp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.res.bizgrp.d.BizGroupDO;
import iih.bd.res.bizgrp.d.BizGrpEmpsDO;
import iih.bd.res.bizgrp.d.BizgrpAggDO;
import iih.bd.res.i.external.provide.IBdResMrQryService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

/**
 * 质控获取消息接收人类
 */
public class QcMsgGetPsnBp {

	/**
	 * 当开启参数[质控整改消息发送病历创建人诊疗组]时，根据用户id集合返回应该发送的消息的用户id集合
	 * 
	 * @param list
	 * @return
	 * @throws BizException
	 */
	public List<String> getUserIdToMsg(List<String> list,String id_dep) throws BizException {
		List<String> empList = new ArrayList<String>();
		IUserRService servUser = ServiceFinder.find(IUserRService.class);
		UserDO[] userDos = servUser.findByIds(list.toArray(new String[list.size()]), FBoolean.FALSE);
		if (null != userDos && userDos.length > 0) {
			for (UserDO userDo : userDos) {
				if (null != userDo.getId_psn() && !"".equals(userDo.getId_psn())) {
					empList.addAll(getEmpList(userDo.getId_psn(),id_dep));
				}
			}
		}

		if (null != empList && empList.size() > 0) {
			UserDO[] empDos = servUser.findByAttrValStrings("Id_psn", empList.toArray(new String[empList.size()]));
			if (null != empDos && empDos.length > 0) {
				for (UserDO empDo : empDos) {
					if (null != empDo.getId_user() && !"".equals(empDo.getId_user())) {
						list.add(empDo.getId_user());
					}
				}
			}
		}

		return list;
	}

	/**
	 * 根据人员id调用xap接口返回应该发送消息的人员id集合
	 * 
	 * @param list
	 * @return
	 * @throws BizException
	 */
	public List<String> getEmpList(String id_psn,String id_dep) throws BizException {
		// xap提供接口
		IBdResMrQryService servPsn = ServiceFinder.find(IBdResMrQryService.class);
		List<String> addList = new ArrayList<String>();

		BizgrpAggDO[] aggDos = servPsn.findBizGrpByPsnId(id_psn);
		BizGrpEmpsDO[] empDos = null;
		BizGroupDO groupDo = null;
		if (null != aggDos && aggDos.length > 0) {
			for (BizgrpAggDO aggDo : aggDos) {
				groupDo = aggDo.getParentDO();// 业务组DO
				//筛选诊疗组
				if (null != groupDo.getSd_wgtp()
						&& (ICiMrDictCodeConst.SD_TYPE_BIZGROUP_ZYZL.equals(groupDo.getSd_wgtp()) || ICiMrDictCodeConst.SD_TYPE_BIZGROUP_ZYZLZ.equals(groupDo.getSd_wgtp()))
						&&  groupDo.getId_dep().equals(id_dep)) {
					empDos = aggDo.getBizGrpEmpsDO();// 业务组组内成员数组
					if (null != empDos && empDos.length > 0) {
						for (BizGrpEmpsDO empDo : empDos) {
							if (null != empDo.getId_emp() && !"".equals(empDo.getId_emp())) {
								addList.add(empDo.getId_emp());
							}
						}
					}
				}
				groupDo = null;
				empDos = null;
			}
		}
		return addList;
	}

	/**
	 * 用户id集合去重
	 * 
	 * @param list
	 * @return
	 */
	public List<String> removeEqual(List<String> list) {
		HashSet h = new HashSet(list);
		list.clear();
		list.addAll(h);
		return list;
	}
}
