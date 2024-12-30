package iih.sc.sch.s.bp.op;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScValidator;
import iih.sc.sch.dto.d.SchCancDTO;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.scsch.d.ScSchDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊排班替诊BP
 * 
 * @author zhengcm
 * @date 2017-11-17 16:16:26
 *
 */
public class OpSchReplaceEntBP {

	/**
	 * 门诊排班替诊
	 * 
	 * @author zhengcm
	 * @date 2017-11-17 16:17:20
	 *
	 * @param originSchId
	 * @param currentSchId
	 * @throws BizException
	 */
	public void exec(String originSchId, String currentSchId) throws BizException {
		// 校验参数
		ScValidator.validateParam("originSchId", originSchId);
		ScValidator.validateParam("currentSchId", currentSchId);

		// 当前排班
		ScSchDO schDO = new SchEP().getById(originSchId);
		if (null == schDO) {
			throw new BizException("没有找到当前排班！");
		}

		// 检查当前排班
		if (!schDO.getFg_active().booleanValue()) {
			throw new BizException("当前排班已停诊，不允许替诊！");
		}

		// 查询当前排班的预约数据
		SchCancDTO[] datas = new GetOpSchCancAptInfoBP().exec(originSchId, FBoolean.FALSE);

		// 过滤掉已取号和已取消的数据以及挂号数据
		List<SchCancDTO> dataList = this.filterAptDatas(datas);
		if (ListUtil.isEmpty(dataList)) {
			return;
		}

		// 执行改约逻辑
		new OpSchChangeAptBP().exec(dataList.toArray(new SchCancDTO[0]), currentSchId);

		// 更新原排班
		this.updateSchCancto(originSchId, currentSchId);
	}

	/**
	 * 过滤掉不可替诊的预约数据：过滤掉已取号和已取消的数据以及挂号数据
	 * 
	 * @author zhengcm
	 * @date 2017-11-21 13:47:47
	 *
	 * @param datas
	 * @return
	 * @throws BizException
	 */
	private List<SchCancDTO> filterAptDatas(SchCancDTO[] datas) throws BizException {
		if (ArrayUtil.isEmpty(datas)) {
			return null;
		}
		List<SchCancDTO> list = new ArrayList<SchCancDTO>();
		for (SchCancDTO data : datas) {
			String sd_status = data.getSd_status();
			if (!StringUtil.isEmptyWithTrim(sd_status)
					&& !(sd_status.equals(IScDictCodeConst.SD_APTSTATUS_FINISH) || sd_status
							.equals(IScDictCodeConst.SD_APTSTATUS_CANCEL))) {
				list.add(data);
			}
		}
		return list;
	}

	/**
	 * 更新替诊排班数据
	 * 
	 * @author zhengcm
	 * @date 2017-11-21 13:54:48
	 *
	 * @param originSchId
	 * @param currentSchId
	 * @throws BizException
	 */
	private void updateSchCancto(String originSchId, String currentSchId) throws BizException {
		SchEP schEP = new SchEP();
		ScSchDO schDO = schEP.getById(originSchId);
		schDO.setStatus(DOStatus.UPDATED);
		schDO.setFg_active(FBoolean.FALSE);
		schDO.setId_scsch_cancto(currentSchId);
		schEP.save(new ScSchDO[] { schDO });
	}
}
