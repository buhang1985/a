package iih.bl.hp.s.bp;

import iih.bl.hp.blhptransbankpay.d.BlHpTransBankPayDO;
import iih.bl.hp.hpexceptioninfodto.d.HpExceptionInfoDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取交易主表数据
 * @author yangyang
 * @review liwq 根据患者id 查询医保登记表中异常数据
 */
public class GetTransDetailBp {

	public HpExceptionInfoDTO[] exec(String strIdPat) throws BizException
	{
//		StringBuilder sb=new StringBuilder();
//		sb.append(" SELECT TRANS.ID_TRANS_OEP,TRANS.ID_PAT,TRANS.BUSINESS_CODE AS CODE_BUSINESS,TRANS.ID_EMP_OPR,PSNDOC.CODE AS CODE_EMP_OPR,");
//		sb.append(" PSNDOC.NAME AS NAME_EMP_OPR,TRANS.STATUS_TRANS,TRANS.DT_TRANSACT dt_trans,TRANS.HP_ENT_SERIAL_NO AS ENT_NO,");
//		sb.append(" TRANS.HP_ENT_SERIAL_NO AS BILL_CODE");
//		sb.append(" FROM HP_TRANSACT_oep TRANS");
//		sb.append(" INNER JOIN BD_PSNDOC PSNDOC ON TRANS.ID_EMP_OPR=PSNDOC.ID_PSNDOC");
//		sb.append(" WHERE TRANS.ID_PAT=? AND TRANS.ID_EMP_OPR=? AND TRANS.BUSINESS_CODE NOT IN('"+ BusinessCodeConstHeNan.DO_OEPREGISTER  +"','"+ BusinessCodeConstHeNan.PRES_ITM_UPLOAD +"')");
//		SqlParam param = new SqlParam();
//		param.addParam(strIdPat);
//		param.addParam(strIdEmp);
//		
//		DAFacade facade=new DAFacade();
//		List<HpTransDetailsDTO> transDetailDtoArr=(List<HpTransDetailsDTO>)facade.execQuery(sb.toString(), param,new BeanListHandler(HpTransDetailsDTO.class));
//		
		/*
		String ss=transDetailDtoArr.get(0).serializeJson();
		try {
			FileUtils.writeStringToFile(new File("d:/11.txt"), ss, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		StringBuilder sb = new StringBuilder();

		sb.append(" select hpoep.id_hp, ");
		sb.append("        hp.name as name_hp, ");
		sb.append("        hpoep.id_ent, ");
		sb.append("        hpoep.id_pat, ");
		sb.append("        hpoep.hp_ent_serialno as Hp_ent_serial_no, ");
		sb.append("        hpoep.dt_reg as dt_reg, ");
		sb.append("        hpoep.no_hp, ");
		sb.append("        stoep.code_st as Code_his_settled, ");
		sb.append("        hpoep.dt_reg as dt_st,  ");
		sb.append("        hpoep.fg_lock, ");
		sb.append("        hpoep.eu_exstatus as eu_exstatus, ");
		sb.append("        hpoep.id_hpentcode, ");
		sb.append("        '00' as code_entp ");
		sb.append("   from bl_hp_entcode_oep hpoep ");
		sb.append("   left join bd_hp hp ");
		sb.append("     on hpoep.id_hp = hp.id_hp ");
		sb.append("   left join bl_st_oep stoep ");
		sb.append("     on (hpoep.hp_ent_serialno = stoep.code_st or hpoep.code_st = stoep.code_st) ");
		sb.append("  where  hpoep.id_pat = ? ");
		sb.append("    and hpoep.fg_lock = 'Y' ");
		sb.append(" union all ");
		sb.append(" select enhp.id_hp, ");
		sb.append("        hp.name as name_hp, ");
		sb.append("        hpip.id_ent, ");
		sb.append("        hpip.id_pat, ");
		sb.append("        hpip.hp_ent_serial_no as Hp_ent_serial_no, ");
		sb.append("        hpip.dt_reg as dt_reg, ");
		sb.append("        hpip.no_hp, ");
		sb.append("        stip.code_st as Code_his_settled, ");
		sb.append("        stip.dt_st as dt_st,  ");
		sb.append("        hpip.fg_lock, ");
		sb.append("        hpip.eu_exstatus as eu_exstatus, ");
		sb.append("        hpip.id_hpentcode, ");
		sb.append("        '10' as code_entp ");
		sb.append("   from bl_hp_entcode hpip ");
		sb.append("   left join en_ent_hp enhp ");
		sb.append("     on enhp.id_ent = hpip.id_ent ");
		sb.append("   left join bd_hp hp ");
		sb.append("     on enhp.id_hp = hp.id_hp ");
		sb.append("   left join bl_st_ip stip ");
		sb.append("     on hpip.id_ent = stip.id_ent ");
		sb.append("  where  hpip.id_pat = ? ");
		sb.append("    and hpip.fg_lock = 'Y' ");
		sb.append("  order by dt_st desc ");

		SqlParam param = new SqlParam();
		param.addParam(strIdPat);
		param.addParam(strIdPat);
		
		DAFacade facade = new DAFacade();
		List<HpExceptionInfoDTO> transDetailDtoArr = (List<HpExceptionInfoDTO>) facade
				.execQuery(sb.toString(), param, new BeanListHandler(HpExceptionInfoDTO.class));
		if(!transDetailDtoArr.isEmpty()){
			String bankSql = " select btindex, referno, posno,dt_trans,bankno,amt,code_entp from bl_hp_transact_bankpay where eu_direct = 1 and id_hpentcode = '" + transDetailDtoArr.get(0).getId_hpentcode() + "' ";
			
			List<BlHpTransBankPayDO> bankInfo = (List<BlHpTransBankPayDO>)new DAFacade().execQuery(bankSql,  new BeanListHandler(BlHpTransBankPayDO.class));
			
			if(bankInfo.isEmpty()) {
				return transDetailDtoArr.toArray(new HpExceptionInfoDTO[transDetailDtoArr.size()]);
			}else {
				transDetailDtoArr.get(0).setBankno(bankInfo.get(0).getBankno());
				transDetailDtoArr.get(0).setTradeindexcode(bankInfo.get(0).getBtindex());
				transDetailDtoArr.get(0).setReferenceno(bankInfo.get(0).getReferno());
				transDetailDtoArr.get(0).setPosno(bankInfo.get(0).getPosno());
				transDetailDtoArr.get(0).setAmt(bankInfo.get(0).getAmt());
				transDetailDtoArr.get(0).setOrigin_tradedate(bankInfo.get(0).getDt_trans().toString());
				return transDetailDtoArr.toArray(new HpExceptionInfoDTO[transDetailDtoArr.size()]);
			}
		}			
		return null; 
	}
}
