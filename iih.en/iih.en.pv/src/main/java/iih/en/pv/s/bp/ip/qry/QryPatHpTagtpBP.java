package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.entagtp.d.EnTagTpDO;
import iih.en.pv.hpdto.d.IpHpRegistDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 查询患者的就诊标签
 * 
 * @author fanlq
 *
 */
public class QryPatHpTagtpBP {

	/***
	 * 查询患者的就诊标签---入院登记使用
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	public void exec(EnHosRegDTO enHosRegDTO) throws BizException{
		if(enHosRegDTO != null && !EnValidator.isEmpty(enHosRegDTO.getId_ent())){
			EnTagTpDO[] tagtps = this.getTagtpBySql(enHosRegDTO.getId_ent());
			if(tagtps != null && tagtps.length > 0){
				for(EnTagTpDO tagtp : tagtps){
					if(!EnValidator.isEmpty(tagtp.getCode_tagtp())){
						switch(tagtp.getCode_tagtp()){
							case IBdFcDictCodeConst.SD_TAGTP_POOR:
								enHosRegDTO.setFg_poor(FBoolean.TRUE);
								break;
							case IBdFcDictCodeConst.SD_TAGTP_MINLIVING:
								enHosRegDTO.setFg_minliving(FBoolean.TRUE);
								break;
							case IBdFcDictCodeConst.SD_TAGTP_FIVEGUAR:
								enHosRegDTO.setFg_fiveguar(FBoolean.TRUE);
								break;
						}
					}
				}
			}
		}
	}
	
	/***
	 * 查询患者的就诊标签-医保转换使用
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	public void hpexec(IpHpRegistDTO ipHpRegist) throws BizException{
		if(ipHpRegist != null && !EnValidator.isEmpty(ipHpRegist.getId_ent())){
			EnTagTpDO[] tagtps = this.getTagtpBySql(ipHpRegist.getId_ent());
			if(tagtps != null && tagtps.length > 0){
				for(EnTagTpDO tagtp : tagtps){
					if(!EnValidator.isEmpty(tagtp.getCode_tagtp())){
						switch(tagtp.getCode_tagtp()){
							case IBdFcDictCodeConst.SD_TAGTP_POOR:
								ipHpRegist.setFg_poor(FBoolean.TRUE);
								break;
							case IBdFcDictCodeConst.SD_TAGTP_MINLIVING:
								ipHpRegist.setFg_minliving(FBoolean.TRUE);
								break;
							case IBdFcDictCodeConst.SD_TAGTP_FIVEGUAR:
								ipHpRegist.setFg_fiveguar(FBoolean.TRUE);
								break;
						}
					}
				}
			}
		}
	}
	/***
	 * 获取此次就诊的患者标签
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public EnTagTpDO[] getTagtpBySql(String id_ent) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select code_tagtp from en_ent_tagtp ");
		sql.append("where id_ent = ? ");
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		@SuppressWarnings("unchecked")
		List<EnTagTpDO> list = (List<EnTagTpDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(EnTagTpDO.class));
		return list.isEmpty() ? null:list.toArray(new EnTagTpDO[]{});
	}
}
