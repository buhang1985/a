package iih.ci.ord.s.bp.dgrtnorder.bp;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.dbutils.handlers.ColumnListHandler;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.dto.dgrtnorderdto.d.DgRtnOrderDTO;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

public class GetReturnBackDrugQuanBP {
	/**
	 * 临床剩余退药量
	 * liyuelong 2019/12/3
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public FDouble getReturnBackdrugQuan(DgRtnOrderDTO dto) throws BizException {
		// 1、条件合法性校验
		if (dto == null) {
			return new FDouble(0);
		}
		if (StringUtil.isEmpty(dto.getId_mm()) || StringUtil.isEmpty(dto.getCode_or())
				|| StringUtil.isEmpty(dto.getId_srv()) || StringUtil.isEmpty(dto.getId_ent())
				|| StringUtil.isEmpty(dto.getId_pkgu_cur())||StringUtil.isEmpty(dto.getSd_srvtp())) {
			return new FDouble(0);
		}
			
		// 2.返回结果
		FDouble sumQuan = getQuan(dto);

		return sumQuan;
	}

	private FDouble getQuan(DgRtnOrderDTO dto) throws BizException {
		SqlParam sqlParam = new SqlParam();//每个参数对应一个问号，勿动！
		sqlParam.addParam(dto.getId_mm());// 物品ID	
		sqlParam.addParam(dto.getCode_or());// 医嘱编码 
		sqlParam.addParam(dto.getId_ent());// 就诊ID 
		sqlParam.addParam(IBdFcDictCodeConst.ID_CODE_ENTP_IP);//就诊类型
		sqlParam.addParam(dto.getId_srv());// 服务ID
		sqlParam.addParam(dto.getId_ent());// 就诊ID
		sqlParam.addParam(dto.getId_pkgu_cur());// 包装单位
		sqlParam.addParam(ICiDictCodeConst.SD_SU_OPEN);// 开立
		sqlParam.addParam(ICiDictCodeConst.SD_SU_SIGN);// 签署
		sqlParam.addParam(ICiDictCodeConst.SD_SU_CHECKTHROUGH);//核对通过

		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append(" select sum(mm.quan_cur) ");
		sqlSb.append(" from ci_or_srv_mm mm ");
		sqlSb.append(" left outer join ci_or_srv srv on mm.id_orsrv=srv.id_orsrv ");
		sqlSb.append(" left outer join ci_order ci on ci.id_or=srv.id_or ");
		sqlSb.append(" where 1=1 ");
		sqlSb.append(" and ci.fg_back='Y' ");
		
		sqlSb.append(" and mm.id_mm=?  ");
		sqlSb.append(" and ci.id_or_src=(select id_or from ci_order where code_or= ? and id_en=? and code_entp=?) ");
		sqlSb.append(" and srv.id_srv=?  ");
		sqlSb.append(" and srv.id_en=?  ");
		sqlSb.append(" and mm.id_pgku_cur=? ");
		sqlSb.append(" and ci.sd_su_or in (?,?,?)");
		
		DAFacade facade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<Integer> list = (List<Integer>) facade.execQuery(sqlSb.toString(), sqlParam, new ColumnListHandler<>());
		
		
		FDouble fDouble = new FDouble(0);
		if (list != null && list.size() > 0) {
			if (null == list.get(0)) {
				return dto.getQuan_bk_max();
			}
			BigDecimal b1 = new BigDecimal(Double.toString(dto.getQuan_bk_max().doubleValue()));
			BigDecimal b2 = new BigDecimal(Double.toString(list.get(0).intValue()));
			// case1：旧数据处理：最大退药量小于等于已保存的退药量
			if (b1.compareTo(b2) == -1 || b1.compareTo(b2) == 0) {
				fDouble = new FDouble(0);
			} else {
				// case2:最大退药量>已保存的退药量
				fDouble = new FDouble(b1.subtract(b2).intValue());
			}
			OrdBizLogger.info(null, "临床剩余退药量类：GetReturnBackDrugQuanBP,剩余退药量：【"+fDouble+"】");
			return fDouble;
		}
		OrdBizLogger.info(null, "调用执行域接口：IMpDgCIService.findIpDrugUseList,返回剩余退药量：【"+dto.getQuan_bk_max()+"】");
		return dto.getQuan_bk_max();
	}
}
