package iih.bd.srv.medsrv.validate;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 服务套基础信息检查
 * 
 * @author qzwang
 *
 */
public class BDSetSrvValidate extends BDBaseSrvValidate {

	@Override
	public Boolean CheckValidate(MedSrvDO medsrv, List<BDErrorInfo> errorList) throws BizException {
		BDErrorInfo info = new BDErrorInfo(medsrv.getId_srv(), medsrv.getName());
		if (!super.CheckValidate(medsrv, errorList)) {
			info = errorList.get(errorList.size() - 1);
		}
		
		// 检查服务套
		CheckSetPropertyInfo(medsrv,info);
		
		// 服务套标记判断
		if ((info.getDescList().size() > 0 || info.getSubItems().size() > 0) && !errorList.contains(info)) {
			errorList.add(info);
		}
		return info.getDescList().size() == 0 && info.getSubItems().size() == 0;
	}
	
	/**
	 * 检查服务套属性表
	 * @param aggDo
	 * @param info
	 * @throws BizException
	 */
	protected void CheckSetPropertyInfo(MedSrvDO medsrv, BDErrorInfo info) throws BizException{
		if (medsrv.getFg_set() != null && medsrv.getFg_set().booleanValue()) {
			MedSrvSetItemDO[] szMedSrvSetItemDO = ServiceFinder.find(IMedSrvSetItemDORService.class).find(String.format(" id_srv = '%s'", medsrv.getId_srv()), "", FBoolean.FALSE);
			if ((szMedSrvSetItemDO == null || szMedSrvSetItemDO.length <= 0)) {
				info.getDescList().add("套内项目属性表为空");

			} else {
				
				CheckSetItemListInfo(medsrv, szMedSrvSetItemDO,info);
			}
		}
	}
	
	/**
	 * 检查所有套内项目
	 * @param items
	 * @param info
	 * @throws BizException
	 */
	protected void CheckSetItemListInfo(MedSrvDO medsrv, MedSrvSetItemDO[] items, BDErrorInfo info) throws BizException{
		
		List<String> srvSetItems = new ArrayList<String>();
		for (MedSrvSetItemDO item : items){
			srvSetItems.add(item.getId_srv_itm());
		}
		
		// 批量查询数据库
		IMedsrvMDORService rService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] szSrvDO = rService.findByIds(srvSetItems.toArray(new String[srvSetItems.size()]),FBoolean.FALSE);
		int index = 0;
		boolean hasClinicalSrv = false;
		boolean hasSameNameSrv = false;
		List<String> nameSrvList = new ArrayList<String>();
		for (MedSrvDO srvDo : szSrvDO) {
			MedSrvSetItemDO setItemDO = items[index++];
			BDErrorInfo subInfo = new BDErrorInfo(setItemDO.getId_srv_itm(), setItemDO.getSet_name());
			if (null == srvDo.getFg_active() ||srvDo.getFg_active().equals(FBoolean.FALSE)) {
				subInfo.getDescList().add("项目未启用");
			}
			
			// 套内项目基础信息检查
			CheckSetItemInfo(setItemDO, subInfo.getDescList());
			
			// 检查套内项目是否存在同名服务
			if (!nameSrvList.contains(setItemDO.getSet_name())){
				nameSrvList.add(setItemDO.getSet_name());
			}
			else{
				// 只检查在一个重名服务即可
				if (!hasSameNameSrv){
					hasSameNameSrv = true;
					subInfo.getDescList().add(String.format("套内项目中存在同名服务"));
				}
			}
			
			// 套内项目服务类型必须和套服务类型一致
			if(!medsrv.getSd_srvtp().equals(srvDo.getSd_srvtp()) && setItemDO.getFg_clinical() == FBoolean.TRUE){
				subInfo.getDescList().add(String.format("服务类型与套不一致，项目:%s,套：%s", srvDo.getSd_srvtp(),medsrv.getSd_srvtp()));
			}
			
			// 检查套内项目必须有一个临床项目
			hasClinicalSrv |= ( setItemDO.getFg_clinical() != null && setItemDO.getFg_clinical() == FBoolean.TRUE);
			
			if (subInfo.getDescList().size() > 0 || subInfo.getSubItems().size() > 0)
				info.getSubItems().add(subInfo);
		}
		
		if(!hasClinicalSrv){
			info.getDescList().add("套内项目中不存在临床项目");
		}
	}

	/**
	 * 检查套内项目
	 * @param s
	 * @param e
	 */
	protected void CheckSetItemInfo(MedSrvSetItemDO s, List<String> e) {
		if (StringUtil.isEmpty(s.getId_srv_itm())) {
			e.add("套内项目为空");
		}
		if (StringUtil.isEmpty(s.getId_srvsetrole())) {
			e.add("成员角色为空");
		}
		if (StringUtil.isEmpty(s.getSd_srvsetrole())) {
			e.add("成员角色编码为空");
		}
		if (s.getQuan_medu()==null || s.getQuan_medu().toDouble().equals(0)) {
			e.add("剂量数值为空");
		}
		if (StringUtil.isEmpty(s.getId_medu())) {
			e.add("剂量单位为空");
		}
		if (s.getFg_clinical()==null) {
			e.add("临床标识为空");
		}
		if (s.getFg_clinical_bl()==null) {
			e.add("临床价格计算标识为空");
		} else {
			if (s.getFg_clinical_bl().equals(FBoolean.TRUE)) {
				if (s.getFg_clinical().equals(FBoolean.FALSE)) {
					e.add("临床价格计算标识与临床标识不匹配");
				}
			}
		}
		if (s.getFg_edit()==(null)) {
			e.add("可选标识为空");
		}
		if (s.getFg_active()==(null)) {
			e.add("启用标识为空");
		}
		if (StringUtil.isEmpty(s.getSd_srvsetrole())) {
			e.add("成员角色编码为空");
		}
		if (StringUtil.isEmpty(s.getId_mpdepcalmd())) {
			e.add("执行科室计算方式为空");
		} else {
			if (s.getId_mpdepcalmd().equals(IBdSrvDictCodeConst.ID_ORTMPLTP_CONSTDEPT)) {
				if (StringUtil.isEmpty(s.getId_dep_mp())) {
					e.add("执行科室固定值为空");
				}
			}
		}
		if (StringUtil.isEmpty(s.getSd_mpdepcalmd())) {
			e.add("执行科室计算方式编码为空");
		}
	}

	
	protected void CheckSetItemSameSrvTp(){
		
	}
}
