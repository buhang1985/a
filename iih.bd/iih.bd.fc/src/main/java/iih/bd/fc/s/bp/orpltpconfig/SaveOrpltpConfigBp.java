package iih.bd.fc.s.bp.orpltpconfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.orpltp.i.IOrpltpStaDOCudService;
import iih.bd.fc.orpltp.i.IOrpltpStaDORService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @Description:闭环状态业务定义
 * @author: xu_xing@founder.com.cn
 * @version：2018年8月17日 下午2:52:45 创建
 */
public class SaveOrpltpConfigBp {

	/**
	 * 主入口
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public OrpltpStaDO[] exec(String id_orpltp, OrpltpStaDO[] params) throws BizException {

		// 1、基础校验
		validation(id_orpltp, params);
 
		// 2、对参数进行排序
		sortBizSta(params);

		// 3、状态配置校验
		validationStatus(params);

		// 4、 闭环状态链表建立
		structBizSta(params);

		// 5、获取定义态的全部状态
		OrpltpStaDO[] stas = getDefStas(id_orpltp);

		// 6、处理未用的状态信息
		OrpltpStaDO[] disableStas = handleDisableSta(stas, params);

		// 7、保存已选闭环状态
		OrpltpStaDO[] rtns = update(params, disableStas);

		return rtns;
	}

	/**
	 * 基础校验
	 * 
	 * @param orpltpDTO
	 * @param orpltpStaDTO
	 * @throws BizException
	 */
	private void validation(String id_orpltp, OrpltpStaDO[] params) throws BizException {
		if (params == null)
			throw new BizException("医嘱闭环配置保存，医嘱闭环配置信息空异常！");
		if (StringUtil.isEmptyWithTrim(id_orpltp))
			throw new BizException("医嘱闭环配置保存，医嘱闭环类型空异常！");
		List<Integer> listSortno = new ArrayList<Integer>();
		boolean fg_save = false;
		for (OrpltpStaDO param : params) {
			if (!fg_save && FBoolean.TRUE.equals(param.getFg_charge()))
				fg_save = true;
			if (param.getSortno() == null)
				throw new BizException("医嘱闭环状态业务定义，序号空异常！");
			if (listSortno.contains(param.getSortno()))
				throw new BizException("医嘱闭环状态业务定义，序号重复异常！");
			if (StringUtil.isEmptyWithTrim(param.getId_orpltp()))
				throw new BizException("医嘱闭环状态业务定义，闭环类型空异常！");
			if (!id_orpltp.equals(param.getId_orpltp()))
				throw new BizException("医嘱闭环状态业务定义，闭环类型不唯一！");
			listSortno.add(param.getSortno());
		}
		if(!fg_save)
			throw new BizException("医嘱闭环配置至少有一个为记账点！请检查！");
	}

	/**
	 * 获取定义态的全部状态
	 * 
	 * @return
	 * @throws BizException
	 */
	private OrpltpStaDO[] getDefStas(String id_orpltp) throws BizException {
		return ServiceFinder.find(IOrpltpStaDORService.class).findByAttrValString(OrpltpStaDO.ID_ORPLTP, id_orpltp);
	}

	/**
	 * 排序
	 * 
	 * @param params
	 */
	private void sortBizSta(OrpltpStaDO[] params) {
		if (params == null || params.length < 1)
			return;
		for (int i = 0; i < params.length; i++) {
			for (int j = i; j < params.length; j++) {
				if (params[j].getSortno() < params[i].getSortno()) {
					OrpltpStaDO tem = params[i];
					params[i] = params[j];
					params[j] = tem;
				}
			}
		}
	}

	/**
	 * 状态配置校验
	 * 
	 * @param params
	 * @throws BizException
	 */
	private void validationStatus(OrpltpStaDO[] params) throws BizException {
		if (params == null || params.length < 1)
			return;
		int maxCancelable = -1, maxFeertnable = -1, minMp = -1;
		for (int i = 0; i < params.length; i++) {
			// 查找最大的可取消标记
			maxCancelable = FBoolean.TRUE.equals(params[i].getFg_cancelable()) ? i : maxCancelable;
			// 查找最大的可作废标记
			maxFeertnable = FBoolean.TRUE.equals(params[i].getFg_feertnable()) ? i : maxFeertnable;
			// 查找最小的执行标记
			if (minMp == -1)
				minMp = FBoolean.TRUE.equals(params[i].getFg_mp()) ? i : minMp;
		}
		// 业务上存在开始执行了就可以不可取消的
		// if (maxCancelable == -1)
		// throw new BizException("医嘱闭环配置保存，当前流程中缺少【可取消标记】配置！");

		// 从业务上考虑，存在开始执行就不可退费
		// if (maxFeertnable==-1)
		// throw new BizException("医嘱闭环配置保存，当前流程中缺少【可取消标记】配置！");

		// 任何一个流程，都有执行完成的时候
		if (minMp == -1)
			throw new BizException("医嘱闭环配置保存，当前流程中缺少【执行标记】配置！");
		for (int i = 0; i < params.length; i++) {
			if (i < maxCancelable && FBoolean.FALSE.equals(params[i].getFg_cancelable()))
				throw new BizException("医嘱闭环配置保存，【可取消标记】配置必须连续！");
			if (maxFeertnable != -1) {
				if (i < maxFeertnable && FBoolean.FALSE.equals(params[i].getFg_feertnable()))
					throw new BizException("医嘱闭环配置保存，【可取消标记】配置必须连续！");
			}
			if (i > minMp && FBoolean.FALSE.equals(params[i].getFg_mp()))
				throw new BizException("医嘱闭环配置保存，【执行标记】配置必须连续！");
		}
	}

	/**
	 * 闭环状态链表建立
	 * 
	 * @param params
	 */
	private void structBizSta(OrpltpStaDO[] params) {
		if (params == null || params.length < 1)
			return;
		for (int i = 0; i < params.length; i++) {
			params[i].setFg_active(FBoolean.TRUE);
			// 前一个节点
			if (i > 0)
				params[i].setId_pre(params[i - 1].getId_orpltpsta());
			// 下一个节点
			if (i < params.length - 1)
				params[i].setId_next(params[i + 1].getId_orpltpsta());
			params[i].setStatus(DOStatus.UPDATED);
		}
		params[0].setId_pre(null);
		params[params.length - 1].setId_next(null);

	}

	/**
	 * 处理未用的状态信息
	 * 
	 * @param stas
	 * @param params
	 * @return
	 */
	private OrpltpStaDO[] handleDisableSta(OrpltpStaDO[] stas, OrpltpStaDO[] params) {
		if (params == null || params.length < 1)
			return stas;
		List<OrpltpStaDO> reList = new ArrayList<OrpltpStaDO>();
		List<String> listSta = this.getAttrValList(params, OrpltpStaDO.ID_ORPLTPSTA);
		for (OrpltpStaDO sta : stas) {
			if (!listSta.contains(sta.getId_orpltpsta())) {
				sta.setFg_active(FBoolean.FALSE);
				sta.setStatus(DOStatus.UPDATED);
				reList.add(sta);
			}
		}
		return reList.toArray(new OrpltpStaDO[0]);
	}

	/**
	 * 获取DO中指定的列集合
	 * 
	 * @param params
	 * @param attrName
	 * @return
	 */
	private List<String> getAttrValList(BaseDO[] params, String attrName) {
		List<String> reList = new ArrayList<String>();
		for (BaseDO param : params) {
			Object key = param.getAttrVal(attrName);
			if (key == null)
				continue;
			if (StringUtil.isEmptyWithTrim(key.toString()))
				continue;
			if (!reList.contains(key.toString()))
				reList.add(key.toString());
		}
		return reList;
	}

	/**
	 * 获取闭环信息
	 * 
	 * @param orpltpDTO
	 * @return
	 * @throws BizException
	 */
	private OrpltpStaDO[] update(OrpltpStaDO[] params, OrpltpStaDO[] disableStas) throws BizException {
		List<OrpltpStaDO> listSave = new ArrayList<OrpltpStaDO>();
		if (params != null && params.length > 0)
			listSave.addAll(Arrays.asList(params));
		if (disableStas != null && disableStas.length > 0)
			listSave.addAll(Arrays.asList(disableStas));
		OrpltpStaDO[] rtns = ServiceFinder.find(IOrpltpStaDOCudService.class).save(listSave.toArray(new OrpltpStaDO[0]));
		return rtns;
	}
}
