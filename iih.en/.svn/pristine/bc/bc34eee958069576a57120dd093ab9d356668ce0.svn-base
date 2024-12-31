package iih.en.pv.s.bp.ip;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.inpatient.d.NewbornDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.SqlBuildHelper;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 查询就诊账户余额
 * 含婴儿处理，婴儿使用母亲账户
 * @author ly 2017/09/11
 * @version ly 2018/09/17 重构婴儿设置逻辑
 */
public class BatchGetBalanceContainBabyBP {
	/**
	 * 查询就诊账户余额
	 * 信用额度=患者信用分类的就诊信用额度+就诊账户的信用额度
	 * 账户余额=就诊预交金-消费金额
	 * 可用余额=患者信用分类的就诊信用额度+就诊账户的信用额度 + 预交金-消费金额
	 * 含婴儿处理，婴儿使用母亲账户
	 * @param entIds 就诊id数组
	 * @return DTO包含：患者预交金总金额、患者信用度总额、未结算费用总额、患者可用费用余额
	 * @throws BizException
	 */
	public BalanceDTO[] exec(String[] entIds) throws BizException{	
		if(EnValidator.isEmpty(entIds)) 
			return null;
		
		//获取新生儿母亲关系
		Map<String,String> babyMap = this.getNewbornInfo(entIds);
		List<String> accEntList = new ArrayList<String>();
		for (String entId : entIds) {
			
			String momEnt = babyMap.get(entId);
			if(EnValidator.isEmpty(momEnt)){
				accEntList.add(entId);
			}else{
				accEntList.add(momEnt);
			}
		}
		
		//获取账户信息
		List<BalanceDTO> result = this.getAccInfo(accEntList.toArray(new String[0]));
        
        if(EnValidator.isEmpty(result))
        	return null;
        
        if(babyMap.size() == 0)
        	return result.toArray(new BalanceDTO[0]);
        
        //baby存在时替换母亲entid
        List<BalanceDTO> allAccList = new ArrayList<BalanceDTO>();
        
        for (String entId : entIds) {
			
			String momEntId = babyMap.get(entId);
			String compEntId = EnValidator.isEmpty(momEntId) ? entId : momEntId;

			for (BalanceDTO balDto : result) {
				if (compEntId.equals(balDto.getId_ent())) {

					if (EnValidator.isEmpty(momEntId)) {
						allAccList.add(balDto);
					} else {
						BalanceDTO newBalDto = (BalanceDTO) balDto.clone();
						newBalDto.setId_ent(entId);
						allAccList.add(newBalDto);
					}
					continue;
				}
			}
		}
        
		return allAccList.toArray(new BalanceDTO[0]);
	}
	
	/**
	 * 获取婴儿及母亲关系
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String,String> getNewbornInfo(String[] entIds) throws BizException{
		
		Map<String,String> map = new HashMap<String,String>();
		
		SqlBuildHelper sqlBuilder = new SqlBuildHelper();
		sqlBuilder.append("select id_ent_bb,id_ent_mom from en_ent_nb where ");
		sqlBuilder.append("id_ent_bb",entIds);
		
		List<NewbornDO> result =(List<NewbornDO>)new DAFacade().execQuery(sqlBuilder.toString(), 
        		new BeanListHandler(NewbornDO.class));
		
		if(EnValidator.isEmpty(result))
			return map;
		
		for (NewbornDO bornDo : result) {
			map.put(bornDo.getId_ent_bb(), bornDo.getId_ent_mom());
		}
		
		return map;
	}

	/**
	 * 获取账户金额信息
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<BalanceDTO> getAccInfo(String[] entIds) throws BizException{
		
		SqlBuildHelper sqlBuilder = new SqlBuildHelper();
		sqlBuilder.append("SELECT ACC.ID_ENT,");
		sqlBuilder.append("ISNULL(ACC.AMT_PREPAY,0) AMT_PREPAY,");
        sqlBuilder.append("ISNULL(ACC.AMT_CRED,0) + ISNULL(CRET.ENCRED,0) AMT_CRED,");
        sqlBuilder.append("ISNULL(ACC.AMT_UNCG,0) AMT_UNCG,");
        sqlBuilder.append("ISNULL(ACC.AMT_PREPAY,0) - ISNULL(ACC.AMT_UNCG,0) AMT_BAL,");
        sqlBuilder.append("ISNULL(ACC.AMT_PREPAY,0) + ISNULL(ACC.AMT_CRED,0) + ISNULL(CRET.ENCRED,0) - ISNULL(ACC.AMT_UNCG,0) AVAILABLE ");
        sqlBuilder.append("FROM EN_ENT_ACC ACC ");
        sqlBuilder.append("INNER JOIN EN_ENT ENT ON ENT.ID_ENT = ACC.ID_ENT ");
        sqlBuilder.append("LEFT JOIN PI_PAT_CRET CRET ON ENT.ID_PATCRET = CRET.ID_PATCRET ");
        sqlBuilder.append("WHERE 1=1 AND ");
        sqlBuilder.append("ACC.ID_ENT",entIds);
        
		List<BalanceDTO> result =(List<BalanceDTO>)new DAFacade().execQuery(sqlBuilder.toString(), 
        		new BeanListHandler(BalanceDTO.class));
        
        return result;
	}
}
