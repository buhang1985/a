package iih.en.pv.s.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.Ent4BannerDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
/**
 * 查询Banner体重数据
 * 
 * @author liubin
 *
 */

public class SetEntBannerWeightBP {
	private static String DECODE_WEIGHT_KG = "DE20.00.005.00";
	private static String DECODE_WEIGHT_G = "DE20.00.020.00";
	/**
	 * 查询Banner体重数据
	 * 
	 * @param bannerDTO
	 * @throws BizException 
	 */
	public void exec(Ent4BannerDTO bannerDTO) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT PRESRV.VAL0 AS WEIGHT, (PRESRV.VAL0 || UNIT.NAME) AS WEIGHTUNIT ");
		sqlBuilder.append("FROM CI_OBS_PRE_SRV PRESRV ");
		sqlBuilder.append("INNER JOIN BD_SRV_VT VT ON PRESRV.ID_SRV = VT.ID_SRV ");
		sqlBuilder.append("INNER JOIN BD_MEASDOC UNIT ON VT.ID_UNIT = UNIT.ID_MEASDOC ");
		sqlBuilder.append("INNER JOIN BD_DE DE ON VT.ID_DE = DE.ID_DE ");
		sqlBuilder.append("WHERE (DE.CODE = ? OR DE.CODE = ?) ");
		sqlBuilder.append("AND PRESRV.ID_ENT = ? ");
		String sql = sqlBuilder.toString();
		SqlParam param = new SqlParam();
		param.addParam(DECODE_WEIGHT_G);
		param.addParam(DECODE_WEIGHT_KG);
		param.addParam(bannerDTO.getId_ent());
		DAFacade dafade = new DAFacade();
		List<Ent4BannerDTO> list = (List<Ent4BannerDTO>) dafade.execQuery(sql, param, new BeanListHandler(Ent4BannerDTO.class));
		if(!EnValidator.isEmpty(list)){
			bannerDTO.setWeight(list.get(0).getWeight());
			bannerDTO.setWeightunit(list.get(0).getWeightunit());
		}
		bannerDTO.setFg_weightshow(FBoolean.FALSE);
		DeptDO dept =  (DeptDO) dafade.findByPK(DeptDO.class, bannerDTO.getId_dep_phy(), new String[]{DeptDO.ID_DEP, DeptDO.SD_CLINICALPROFESSIONTP});
	    if(dept != null 
	    		&& !EnValidator.isEmpty(dept.getSd_clinicalprofessiontp())
	    		&& dept.getSd_clinicalprofessiontp().startsWith("4"))
	    	bannerDTO.setFg_weightshow(FBoolean.TRUE);
	}
}
