package iih.ei.idrgn.s.bp;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.ei.idrgn.dto.prepayverify.d.PrepayPatVerifyDTO;
import iih.pi.reg.i.IPiRegValidateService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 预交金患者身份校验
 * @author ly 2018/01/25
 *
 */
public class IdrgnPrepayPatVerifyBP {

	/**
	 * 预交金患者身份校验
	 * @param dto 校验信息
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(PrepayPatVerifyDTO dto) throws BizException {
		
		//入参校验
		this.validate(dto);
		
		//1.密码校验
		if(!StringUtil.isEmpty(dto.getPassword())){
			return this.validatePsw(dto);
		}
		
		//2.身份证校验
		if(!StringUtil.isEmpty(dto.getId_code())){
			return this.validateID(dto);
		}
		
		//3.医保卡校验
		if(!StringUtil.isEmpty(dto.getNo_hp())){
			return this.validateHp(dto);
		}
		
		//4.IC卡校验
		if(!StringUtil.isEmpty(dto.getCard_code())){
			return this.validateCard(dto);
		}
		//5.磁条卡校验
		if(!StringUtil.isEmpty(dto.getMagnetic_code())){
			return this.validateMagneticCard(dto);
		}
		return FBoolean.FALSE;
	}
	
	/**
	 * 入参校验
	 * @param dto
	 * @throws BizException
	 */
	private void validate(PrepayPatVerifyDTO dto) throws BizException {
		
		if(dto == null){
			throw new ArgumentNullException("预交金患者身份校验","校验信息");
		}
		
		if(StringUtil.isEmpty(dto.getId_pat())){
			throw new ArgumentNullException("预交金患者身份校验","患者id");
		}
		
		if(StringUtil.isEmpty(dto.getPassword()) && StringUtil.isEmpty(dto.getId_code()) &&
				StringUtil.isEmpty(dto.getNo_hp()) && StringUtil.isEmpty(dto.getCard_code())
				&& StringUtil.isEmpty(dto.getMagnetic_code())){
			throw new BizException("预交金患者身份校验:至少选择一种校验类型");
		}
	}

	/**
	 * 校验密码
	 * @param dto
	 * @throws BizException
	 */
	private FBoolean validatePsw(PrepayPatVerifyDTO dto)throws BizException {
		IPiRegValidateService pswService = ServiceFinder.find(IPiRegValidateService.class);
		return pswService.checkPatPassword(dto.getId_pat(), dto.getPassword());
	}
	
	/**
	 * 校验身份证
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private FBoolean validateID(PrepayPatVerifyDTO dto)throws BizException {
		String sql = "select count(1) from pi_pat where id_pat = ? "
				+ "and sd_idtp = ? and id_code = ? and ds = 0";
		SqlParam param = new SqlParam();
		param.addParam(dto.getId_pat());
		param.addParam(IPiDictCodeConst.SD_IDTP_IDENTITY);
		param.addParam(dto.getId_code());
		Integer count = (Integer)new DAFacade().execQuery(sql, param, new ColumnHandler());
		if(count == null || count == 0){
			return FBoolean.FALSE;
		}
		return FBoolean.TRUE;
	}
	
	/**
	 * 校验医保卡号
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private FBoolean validateHp(PrepayPatVerifyDTO dto)throws BizException {
		String sql = "select count(1) from pi_pat inner join pi_pat_hp "
				+ "on pi_pat.id_pat = pi_pat_hp.id_pat "
				+ "where pi_pat.id_pat = ? "
				+ "and pi_pat_hp.no_hp = ? "
				+ "and pi_pat.ds = 0";
		SqlParam param = new SqlParam();
		param.addParam(dto.getId_pat());
		param.addParam(dto.getNo_hp());
		Integer count = (Integer)new DAFacade().execQuery(sql, param, new ColumnHandler());
		if(count == null || count == 0){
			return FBoolean.FALSE;
		}
		return FBoolean.TRUE;
	}
	/**
	 * 校验IC卡号
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private FBoolean validateCard(PrepayPatVerifyDTO dto)throws BizException {
		String sql = "select count(1) from pi_pat inner join pi_pat_card "
				+ "on pi_pat.id_pat = pi_pat_card.id_pat "
				+ "where pi_pat.id_pat = ? "
				+ "and pi_pat_card.code = ? "
				+ "and pi_pat.ds = 0";
		SqlParam param = new SqlParam();
		param.addParam(dto.getId_pat());
		param.addParam(dto.getCard_code());
		Integer count = (Integer)new DAFacade().execQuery(sql, param, new ColumnHandler());
		if(count == null || count == 0){
			return FBoolean.FALSE;
		}
		return FBoolean.TRUE;
	}
	/**
	 * 校验IC卡号
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private FBoolean validateMagneticCard(PrepayPatVerifyDTO dto)throws BizException {
		String sql = "select count(1) from pi_pat inner join pi_pat_card "
				+ "on pi_pat.id_pat = pi_pat_card.id_pat "
				+ "where pi_pat.id_pat = ? "
				+ "and pi_pat_card.code = ? "
				+ "and pi_pat.ds = 0 and pi_pat_card.fg_act='Y' ";
		SqlParam param = new SqlParam();
		param.addParam(dto.getId_pat());
		param.addParam(dto.getMagnetic_code());
		Integer count = (Integer)new DAFacade().execQuery(sql, param, new ColumnHandler());
		if(count == null || count == 0){
			return FBoolean.FALSE;
		}
		return FBoolean.TRUE;
	}
}
