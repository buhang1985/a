package iih.sc.apt.s.bp;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.AptPayDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.i.IScBdQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 诊间预约BP
 * @author yank
 *
 */
public class AptOpInRoomBP {
	/**
	 * 诊间预约
	 * @param aptDTO 预约DTO
	 * @param isAuth 授权预约
	 * @param isPrePay 是否预付费
	 * @param payDTO 支付DTO,TODO 参数暂时未用
	 * @throws BizException
	 */
	public String exec(OpAptDTO aptDTO, FBoolean isAuth, FBoolean isPrePay,AptPayDTO payDTO) throws BizException {
		// 参数校验
		this.validate(aptDTO, isAuth, isPrePay, payDTO);
		// 获取诊间渠道
		String chlId = null;
		if (FBoolean.TRUE.equals(isAuth)) {
			// 获取诊间预约渠道
			IScSchOutQryService schQryService = ServiceFinder.find(IScSchOutQryService.class);
			ScSchChlDO schChlDO = schQryService.getSchChl(aptDTO.getId_sch(),IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM);
			if (schChlDO == null) {
				throw new BizException(IScMsgConst.SC_APT_OP_SCH_CHL_INROOM_NOT_EXISTS);
			}
			chlId = schChlDO.getId_scchl();
		} else {
			chlId = aptDTO.getId_scchl();
			if(ScValidator.isEmptyIgnoreBlank(chlId)){
				IScBdQryService scBdQryService = ServiceFinder.find(IScBdQryService.class);
				SchedulechlDO[] chlDOs = scBdQryService.getChlByTp(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM_DEPT);
				if (ArrayUtil.isEmpty(chlDOs)) {
					throw new BizException(IScMsgConst.SC_SCBD_SCCHL_NOT_EXIST);
				}
				chlId = chlDOs[0].getId_scchl();
			}
		}

		AptOpBP aptBP = new AptOpBP();
		return aptBP.exec(aptDTO, isAuth, isPrePay, chlId, payDTO);
	}
	/**
	 * 校验参数
	 * @param patDO
	 * @param aptDTO
	 * @param isAuth
	 * @param isPrePay
	 * @param payDTO
	 * @throws BizException
	 */
	private void validate(OpAptDTO aptDTO,FBoolean isAuth,FBoolean isPrePay,AptPayDTO payDTO) throws BizException{
		if(aptDTO==null){
			throw new BizException("参数预约信息为null!");
		}else if(StringUtils.isEmpty(aptDTO.getId_pat())){
			throw new BizException("患者id为空！");
		}
	}	
}
