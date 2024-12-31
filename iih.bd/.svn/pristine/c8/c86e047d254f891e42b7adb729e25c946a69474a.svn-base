package iih.bd.srv.mrfpbltype.s.bp;

import java.util.ArrayList;

import iih.bd.srv.mrfpbltype.d.MrFpBlTypeDO;
import iih.bd.srv.mrfpbltype.d.MrFpBlTypeProDO;
import iih.bd.srv.mrfpbltype.i.IMrFpBlTypeProDORService;
import iih.bd.srv.mrfpbltype.i.IMrfpbltypeMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.validation.ValidationFailure;

/**
 * 首页费用分类明细唯一性检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MrFpBlTypeProUniqueValidateBp {

	public void exec(MrFpBlTypeProDO[] dataArr) throws BizException {
		if (dataArr == null || dataArr.length <= 0) {
			return;
		}

		ArrayList<MrFpBlTypeProDO> mrFpBlTypeProList = getDataList(dataArr);

		while (mrFpBlTypeProList != null && mrFpBlTypeProList.size() > 0) {

			// 获取同主Do下子Do列表
			ArrayList<MrFpBlTypeProDO> itemList = new ArrayList<MrFpBlTypeProDO>();
			MrFpBlTypeProDO mrFpBlTypeProDO = mrFpBlTypeProList.get(0);
			for (MrFpBlTypeProDO data : mrFpBlTypeProList) {
				if (data.getId_bl_cia().equals(mrFpBlTypeProDO.getId_bl_cia())) {
					itemList.add(data);
				}
			}

			// 从list中移除
			for (MrFpBlTypeProDO item : itemList) {
				mrFpBlTypeProList.remove(item);
			}
			// 唯一性检查
			checkUnique(itemList);
		}
	}

	/**
	 * 检查唯一性
	 * 
	 * @param itemList
	 * @return
	 * @throws BizException
	 */
	private void checkUnique(ArrayList<MrFpBlTypeProDO> itemList) throws BizException {
		checkList(itemList);
		checkDb(itemList);
	}

	/**
	 * 检查列表重复
	 * 
	 * @param itemList
	 * @return
	 * @throws BizException
	 */
	private ValidationFailure checkList(ArrayList<MrFpBlTypeProDO> itemList) throws BizException {
		for (int i = 0; i < itemList.size(); i++) {
			MrFpBlTypeProDO mrFpBlTypeProDO = itemList.get(i);
			for (int j = 0; j < itemList.size(); j++) {
				MrFpBlTypeProDO temp = itemList.get(j);
				if (mrFpBlTypeProDO.getId_bl_cla_itm() != null && temp.getId_bl_cla_itm() != null
						&& !mrFpBlTypeProDO.getId_bl_cla_itm().equals(temp.getId_bl_cla_itm())
						&& mrFpBlTypeProDO.getId_bl_itm().equals(temp.getId_bl_itm())) {
					String msg = String.format("服务项目收费分类类型不允许重复。\n\"%s\"重复", mrFpBlTypeProDO.getBl_item_name());
					throw new BizException(msg);
				}
			}
		}
		return null;
	}

	/**
	 * 检查数据库数据
	 * 
	 * @param itemList
	 * @return
	 * @throws BizException
	 */
	private void checkDb(ArrayList<MrFpBlTypeProDO> itemList) throws BizException {
		MrFpBlTypeDO[] typeDoArr = getAllTypeDo();
		if (typeDoArr == null) {
			return;
		}
		MrFpBlTypeProDO firstData = itemList.get(0);
		MrFpBlTypeDO rootCate = getRootCate(typeDoArr, firstData);
		MrFpBlTypeDO[] childMrFpBlTypeList = getChildMrFpBlTypeList(typeDoArr, rootCate);
		MrFpBlTypeProDO[] childItemArr = getchildItemArr(childMrFpBlTypeList);
		checkUnique(itemList, childItemArr);
	}

	/**
	 * 获取子分类数据列表
	 * 
	 * @param typeDoArr
	 * @param rootCate
	 * @return
	 */
	private MrFpBlTypeDO[] getChildMrFpBlTypeList(MrFpBlTypeDO[] typeDoArr, MrFpBlTypeDO rootCate) {
		ArrayList<MrFpBlTypeDO> childList = new ArrayList<MrFpBlTypeDO>();
		if (StringUtil.isEmptyWithTrim(rootCate.getInnercode())) {
			return null;
		}
		for (MrFpBlTypeDO mrFpBlTypeDO : typeDoArr) {
			if (StringUtil.isEmptyWithTrim(mrFpBlTypeDO.getInnercode())) {
				continue;
			}
			if (mrFpBlTypeDO.getInnercode().indexOf(rootCate.getInnercode()) == 0) {
				childList.add(mrFpBlTypeDO);
			}
		}
		return childList.toArray(new MrFpBlTypeDO[childList.size()]);
	}

	/**
	 * 获取分类的项目列表
	 * 
	 * @param childMrFpBlTypeList
	 * @return
	 * @throws BizException
	 */
	private MrFpBlTypeProDO[] getchildItemArr(MrFpBlTypeDO[] childMrFpBlTypeList) throws BizException {
		ArrayList<String> idList = new ArrayList<String>();
		for (MrFpBlTypeDO mrFpBlTypeDO : childMrFpBlTypeList) {
			idList.add(mrFpBlTypeDO.getId_bl_cia());
		}

		IMrFpBlTypeProDORService mrFpBlTypeProDORService = ServiceFinder.find(IMrFpBlTypeProDORService.class);
		MrFpBlTypeProDO[] result = mrFpBlTypeProDORService.findByAttrValStrings(MrFpBlTypeProDO.ID_BL_CIA,
				idList.toArray(new String[idList.size()]));

		return result;
	}

	/**
	 * 新数据与元数据进行对比
	 * 
	 * @param itemList
	 * @param childItemArr
	 * @return
	 * @throws BizException
	 */
	private void checkUnique(ArrayList<MrFpBlTypeProDO> itemList, MrFpBlTypeProDO[] childItemArr) throws BizException {
		for (MrFpBlTypeProDO item : itemList) {
			for (MrFpBlTypeProDO mrFpBlTypeProDO : childItemArr) {
				if (!item.getId_bl_cia().equals(mrFpBlTypeProDO.getId_bl_cia())
						&& item.getId_bl_itm().equals(mrFpBlTypeProDO.getId_bl_itm())) {
					String msg = String.format("服务项目收费分类类型不允许重复。\n\"%s\"重复。", item.getBl_item_name());
					throw new BizException(msg);
				}
			}
		}
	}

	/**
	 * 获取根分类
	 * 
	 * @param firstData
	 * @return
	 * @throws BizException
	 */
	private MrFpBlTypeDO getRootCate(MrFpBlTypeDO[] typeDoArr, MrFpBlTypeProDO firstData) throws BizException {

		MrFpBlTypeDO mrFpBlTypeDO = getMrFpBlTypeDO(typeDoArr, firstData);
		MrFpBlTypeDO rootData;
		do {
			rootData = getParentCate(typeDoArr, mrFpBlTypeDO);
		} while (StringUtil.isEmptyWithTrim(rootData.getId_parent()));
		return rootData;
	}

	/**
	 * 获取所有分类
	 * 
	 * @return
	 * @throws BizException
	 */
	private MrFpBlTypeDO[] getAllTypeDo() throws BizException {
		IMrfpbltypeMDORService mdorService = ServiceFinder.find(IMrfpbltypeMDORService.class);
		String whereStr = String.format("id_grp = '%s' and id_org = '%s'", Context.get().getGroupId(),
				Context.get().getOrgId());
		MrFpBlTypeDO[] result = mdorService.find(whereStr, "", new FBoolean(false));
		return result;
	}

	/**
	 * 根据子DO获取父分类
	 * 
	 * @param typeDoArr
	 * @param firstData
	 * @return
	 * @throws BizException
	 */
	private MrFpBlTypeDO getMrFpBlTypeDO(MrFpBlTypeDO[] typeDoArr, MrFpBlTypeProDO firstData) throws BizException {
		for (MrFpBlTypeDO temp : typeDoArr) {
			if (temp.getId_bl_cia().equals(firstData.getId_bl_cia())) {
				return temp;
			}
		}
		String msg = String.format("病案首页费用分类获取失败,病案首页费用分类id:%s。", firstData.getId_bl_cia());
		throw new BizException(msg);
	}

	/**
	 * 获取父分类
	 * 
	 * @param typeDoArr
	 * @param mrFpBlTypeDO
	 * @return
	 * @throws BizException
	 */
	private MrFpBlTypeDO getParentCate(MrFpBlTypeDO[] typeDoArr, MrFpBlTypeDO mrFpBlTypeDO) throws BizException {
		for (MrFpBlTypeDO temp : typeDoArr) {
			if (temp.getId_bl_cia().equals(mrFpBlTypeDO.getId_parent())) {
				return temp;
			}
		}
		String msg = String.format("病案首页费用分类获取失败,病案首页费用分类id:%s。", mrFpBlTypeDO.getId_bl_cia());
		throw new BizException(msg);
	}

	/**
	 * 获取数据列表
	 * 
	 * @param dataArr
	 * @throws BizException
	 */
	private ArrayList<MrFpBlTypeProDO> getDataList(Object[] dataArr) throws BizException {
		ArrayList<MrFpBlTypeProDO> mrFpBlTypeProList = new ArrayList<MrFpBlTypeProDO>();
		for (Object obj : dataArr) {
			if (obj instanceof MrFpBlTypeProDO) {
				MrFpBlTypeProDO mrFpBlTypeProDO = (MrFpBlTypeProDO) obj;
				if (StringUtil.isEmptyWithTrim(mrFpBlTypeProDO.getId_bl_cia())) {
					throw new BizException("MrFpBlTypeProDO中Id_bl_cia为空。");
				}
				if (DOStatus.DELETED != mrFpBlTypeProDO.getStatus()) {
					mrFpBlTypeProList.add(mrFpBlTypeProDO);
				}
			}
		}
		return mrFpBlTypeProList;
	}

}
