package iih.sc.sch.s.bp.qry;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.comm.ScValidator;
import iih.sc.sch.dto.d.SchCancDTO;
import iih.sc.sch.s.bp.op.GetOpSchCancAptInfoBP;
import java.util.ArrayList;
import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;

/**
 * 获取停诊排班下需要取消预约的记录
 * 
 * @author yzh
 *
 */
public class GetCancAptByStopSchBP {

	/**
	 * 获取停诊排班下需要取消预约的记录
	 * 
	 * @return
	 * @throws BizException
	 */
	public OpAptDTO[] exec(String id_sch) throws BizException {
		// 校验参数
		ScValidator.validateParam("id_sch", id_sch);
		// 获取当前排班预约数据
		SchCancDTO[] datas = new GetOpSchCancAptInfoBP().exec(id_sch, FBoolean.FALSE);
		// 处理返回数据
		return this.handleData(datas);
	}

	/**
	 * 处理数据 转换为opAptDTO
	 * 
	 * @param datas
	 * @return
	 */
	private OpAptDTO[] handleData(SchCancDTO[] datas) {
		if (ArrayUtil.isEmpty(datas)) {
			return null;
		}
		List<OpAptDTO> result = new ArrayList<OpAptDTO>();
		// 目前只能循环逐个退约
		for (SchCancDTO data : datas) {
			if (IScDictCodeConst.SD_APTSTATUS_ORDER.equals(data.getSd_status())
					|| IScDictCodeConst.SD_APTSTATUS_PAY.equals(data.getSd_status())) {
				OpAptDTO dto = new OpAptDTO();
				dto.setQueno(data.getQueno());
				dto.setId_apt(data.getId_apt());
				dto.setId_tick(data.getId_tick());
				dto.setId_ent(data.getId_ent());
				dto.setType_msg(2);
				dto.setName_pat(data.getName_pat());
				dto.setDt_b(new FDateTime(data.getD_sch(), data.getDt_b()));
				result.add(dto);
			}
		}
		return result.toArray(new OpAptDTO[0]);
	}
}
