package iih.en.comm.ep;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import iih.bd.base.utils.SqlUtils;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.NewbornDTO;
import iih.en.pv.inpatient.i.INewbornCudService;
import iih.en.pv.inpatient.i.INewbornRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.SqlBuildHelper;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 新生儿记录EP
 * 
 * @author yank
 *
 */
public class NbEP {
    
    //价格分类
    private Map<String, Object> pripatmap;
 
    /**
     * 获取患者的新生儿记录
     * @param momEntId
     * @return
     * @throws BizException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public NewbornDTO[] exec(String momEntId) throws BizException, IllegalAccessException, InvocationTargetException {
        EnValidator.validateParam("就诊ID", momEntId);
        NewbornDTO[] dtos = this.NewbornDOtoNewbornDTO(momEntId);
        return dtos;
    }
    
    /**
     * NewbornDO数组转为NewbornDTO数组
     * @param momEntId
     * @return
     * @throws BizException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private NewbornDTO[] NewbornDOtoNewbornDTO(String momEntId) throws BizException, IllegalAccessException, InvocationTargetException {
        NewbornDO[] newbornDOs = this.getNbListByMomEnt(momEntId);
        NewbornDTO[] dtos = new NewbornDTO[newbornDOs.length];
        //存储就诊id 用于查询价格分类
        String[] entids = new String[newbornDOs.length];
        if (EnValidator.isEmpty(newbornDOs)  ) {
            return null;
        }
        for (int i = 0; i < newbornDOs.length; i++) {
            NewbornDTO dto = new NewbornDTO();
            NewbornDO nbdo = newbornDOs[i];
            BeanUtils.copyProperties(dto,newbornDOs[i] );
            //设置父亲民族
            dto.setName_nation_dad(nbdo.getName_nation());
            //设置证件类型
            dto.setName_idtp_dad(nbdo.getName_idtp());
            //设置健康状态
            dto.setName_newbb_health(nbdo.getName_healthy());
            dtos[i] = dto;
            //获取新生儿就诊记录id
            entids[i]=dto.getId_ent_bb();
        }
        this.setpripat(entids, dtos);
        return dtos;
    }
    
    /**
     * 设置价格分类到新生儿dto中
     * @throws DAException 
     */
    private void setpripat(String[] entids,NewbornDTO[] dtos) throws DAException {
        this.initpripatmap(entids);
        if ( !EnValidator.isEmpty(dtos) && this.pripatmap!= null) {
            for (NewbornDTO item : dtos) {
                NewbornDTO dto = (NewbornDTO) this.pripatmap.get(item.getId_entnb());
                if (dto!= null) {
                    item.setId_pripat(dto.getId_pripat());
                    item.setName_paticate(dto.getName_paticate());
                }
            }
        }
        
    }
    
    /**
     * 初始化价格分类map
     * @param entids
     * @throws DAException
     */
    private void initpripatmap(String[] entids) throws DAException {
        List<NewbornDTO> getpripat = this.getpripat(entids);
        this.pripatmap = new HashMap<String,Object>();
        if ( !EnValidator.isEmpty(getpripat)) {
            for (NewbornDTO item : getpripat) {
                if (item != null && !EnValidator.isEmpty(item.getId_entnb())) {
                    this.pripatmap.put(item.getId_entnb(), item);
                }
            }
        }
    }
    
    /**
     * 获取价格分类
     * @return
     * @throws DAException 
     */
    private List<NewbornDTO> getpripat(String[] entids) throws DAException{
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT");
        sqlSb.append(" NB.ID_ENTNB,");
        sqlSb.append(" ENT.ID_PRIPAT,");
        sqlSb.append(" PRI_PAT.NAME AS NAME_PATICATE");
        sqlSb.append(" FROM EN_ENT_NB NB");
        sqlSb.append(" LEFT JOIN EN_ENT ENT ON ENT.ID_ENT = NB.ID_ENT_BB");
        sqlSb.append(" LEFT JOIN BD_PRI_PAT PRI_PAT ON PRI_PAT.ID_PRIPAT = ENT.ID_PRIPAT");
        sqlSb.append(" WHERE ");
        if (!EnValidator.isEmpty(entids)) {
            String inSqlByIds = SqlUtils.getInSqlByIds("ENT.ID_ENT", entids);
            sqlSb.append(inSqlByIds);
            List<NewbornDTO> list = (List<NewbornDTO>)new DAFacade().execQuery(sqlSb.toString(), new BeanListHandler(NewbornDTO.class));
            return list;
        }

        return null;
    }
    
    /**
     * 获取患者的新生儿记录
     * 
     * @param momEntId 母亲就诊ID
     * @return
     * @throws BizException
     * @author zhengcm
     */
    public NewbornDO[] getNbListByMomEnt(String momEntId) throws BizException {
        EnValidator.validateParam("就诊ID", momEntId);
        // 新生儿记录查询服务
        INewbornRService qryService = ServiceFinder.find(INewbornRService.class);
        String where = "id_ent_mom = '" + momEntId + "'";
        return qryService.find(where, "no_bb", FBoolean.FALSE);
    }

    /**
     * 获取患者的新生儿记录(在院)(不包括分床新生儿)
     * 
     * @param momEntId 母亲就诊ID
     * @return
     * @throws BizException
     * @author ren_ying
     */
    @SuppressWarnings("unchecked")
    public NewbornDO[] getNbListByMomEntInHos(String momEntId) throws BizException {
        EnValidator.validateParam("就诊ID", momEntId);
        // 新生儿记录查询服务
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(" select nb.* from en_ent ent");
        strBuffer.append(" inner join en_ent_nb  nb");
        strBuffer.append(" on ent.id_ent = nb.id_ent_bb");
        strBuffer.append(" where ent.fg_ip ='Y' ");
        strBuffer.append(" and nb.id_ent_mom = ? ");
        strBuffer.append(" and nb.fg_sepa != 'Y' ");
        SqlParam param = new SqlParam();
        param.addParam(momEntId);
        List<NewbornDO> list = (List<NewbornDO>) new DAFacade().execQuery(strBuffer.toString(),
                param, new BeanListHandler(NewbornDO.class));
        return list.toArray(new NewbornDO[] {});
    }

    /**
     * 新增新生儿记录
     * 
     * @author zhengcm
     * @param newbornDOs 新生儿记录DO数组
     * 
     * @return 新增后的新生儿DO数据
     * @throws BizException
     */
    public NewbornDO[] insertNbDOs(NewbornDO[] newbornDOs) throws BizException {
        if (EnValidator.isEmpty(newbornDOs)) {
            return null;
        }
        // 新生儿记录维护服务
        INewbornCudService cmdService = ServiceFinder.find(INewbornCudService.class);
        return cmdService.insert(newbornDOs);
    }

    /**
     * 更新新生儿记录
     * 
     * @author zhengcm
     * @param newbornDOs 新生儿记录DO数组
     * @return 更新后的新生儿记录数据
     * @throws BizException
     */
    public NewbornDO[] updateNbDOs(NewbornDO[] newbornDOs) throws BizException {
        if (EnValidator.isEmpty(newbornDOs)) {
            return null;
        }
        // 新生儿记录维护服务
        INewbornCudService cmdService = ServiceFinder.find(INewbornCudService.class);
        return cmdService.update(newbornDOs);
    }

    /**
     * 删除新生儿记录
     * 
     * @author zhengcm
     * @param newbornDOs 新生儿记录DO数组
     * @throws BizException
     */
    public void deleteNbDOs(NewbornDO[] newbornDOs) throws BizException {
        if (EnValidator.isEmpty(newbornDOs)) {
            return;
        }
        // 新生儿记录维护服务
        INewbornCudService cmdService = ServiceFinder.find(INewbornCudService.class);
        cmdService.delete(newbornDOs);
    }

    /**
     * 更新新生儿母亲就诊信息
     * 
     * @author zhengcm
     * @param nbDO 新生儿记录DO
     * @throws BizException
     */
    public void updateMomEntIpInfo(NewbornDO nbDO) throws BizException {
        IpEP ipEP = new IpEP();
        InpatientDO momIpDO = null;
        InpatientDO[] DOs = ipEP.getIpDOByEntId(nbDO.getId_ent_mom());
        if (!EnValidator.isEmpty(DOs)) {
            momIpDO = DOs[0];
        }
        if (null == momIpDO) {
            return;
        }
        momIpDO.setStatus(DOStatus.UPDATED);
        int babyCount = 0;
        NewbornDO[] bornDOs = new NbEP().getNbListByMomEnt(nbDO.getId_ent_mom());
        if (!EnValidator.isEmpty(bornDOs)) {
            babyCount = bornDOs.length;
        }
        momIpDO.setNum_newborn(babyCount);
        ipEP.updateIpDOs(new InpatientDO[] { momIpDO });
    }

    /**
     * 批量获取新生儿记录
     * 
     * @param entIdList
     * @return
     * @throws BizException
     */
    public NewbornDO[] getNbChildren(List<String> entIdList) throws BizException {
       if(EnValidator.isEmpty(entIdList))
    	   return null;
        INewbornRService rservice = ServiceFinder.find(INewbornRService.class);
        NewbornDO[] nbBBDOs = rservice.findByAttrValStrings(NewbornDO.ID_ENT_BB, entIdList.toArray(new String[0]));
        return nbBBDOs;
    }

    /**
     * 批量获取母亲
     * 
     * @param entIdList
     * @return
     * @throws BizException
     */
    public NewbornDO[] getNbMoms(List<String> entIdList) throws BizException {
    	if(EnValidator.isEmpty(entIdList))
     	   return null;
        INewbornRService rservice = ServiceFinder.find(INewbornRService.class);
        NewbornDO[] nbMMDOs = rservice.findByAttrValStrings(NewbornDO.ID_ENT_MOM, entIdList.toArray(new String[0]));
        return nbMMDOs;
    }

    /**
     * 获取就诊id（带婴儿）的list
     * 
     * @param patDTO
     * @return
     * @throws BizException
     */
    public ArrayList<String> getEntIdList(String entId) throws BizException {
        if (EnValidator.isEmpty(entId))
            return null;
        ArrayList<String> entIdList = new ArrayList<String>();
        entIdList.add(entId);
        NewbornDO[] nbdos = this.getNbListByMomEntInHos(entId);
        if (EnValidator.isEmpty(nbdos))
            return entIdList;
        for (NewbornDO nbDO : nbdos) {
            entIdList.add(nbDO.getId_ent_bb());
        }
        return entIdList;

    }
    
    /**
     * 获取新生儿记录
     * @param entId
     * @return
     * @throws BizException 
     */
    public NewbornDO getNbChild(String entId) throws BizException{
        INewbornRService rservice = ServiceFinder.find(INewbornRService.class);
        NewbornDO[] nbBBDOs = rservice.findByAttrValString(NewbornDO.ID_ENT_BB, entId);
        if(EnValidator.isEmpty(nbBBDOs))
            return null;
        return nbBBDOs[0];
    }
    
    
    
    
    /**
     * 获取新生儿记录
     * @param entId
     * @return
     * @throws BizException 
     */
    public NewbornDO getNbDO(String entId) throws BizException{
    	if (EnValidator.isEmpty(entId)) {
			return null;
		}
		SqlBuildHelper sqlBuilder = new SqlBuildHelper();
		sqlBuilder.append(" select nb.* ");
		sqlBuilder.append(" from en_ent ent ");
		sqlBuilder.append("	inner join en_ent_ip  ip ");
		sqlBuilder.append(" on ent.id_ent = ip.id_ent");
		sqlBuilder.append(" inner join en_ent_nb nb");
		sqlBuilder.append(" on ent.id_ent = nb.id_ent_bb");
		sqlBuilder.append("	where ip.fg_newborn ='Y'");
		sqlBuilder.append("	and ent.id_ent = ? ");
		SqlParam param = new SqlParam();
		param.addParam(entId);
		@SuppressWarnings("unchecked")
		List<NewbornDO> result = (List<NewbornDO>) new DAFacade().execQuery(sqlBuilder.toString(),
				param, new BeanListHandler(NewbornDO.class));

		if (EnValidator.isEmpty(result)) {
			return null;
		}
		return result.get(0);
    }
    
    /***
	 * 修改en_ent_nb，设置分离标志
	 * @param id_ent
	 * @param fg_sepa
	 * @throws BizException
	 */
	public NewbornDO setNbBornDOSepa(String id_ent,FBoolean fg_sepa) throws BizException{
		NbEP nbep = new NbEP();
		NewbornDO newBornDO = nbep.getNbDO(id_ent);
		if(newBornDO == null)
			throw new BizException("未找到该就诊对应的新生儿，请确认！");
		newBornDO.setDs(DOStatus.UPDATED);
		newBornDO.setFg_sepa(fg_sepa);
		nbep.updateNbDOs(new NewbornDO[]{newBornDO});
		if(FBoolean.TRUE.equals(fg_sepa)){
			EnLogUtil.getInstance().logError("母婴分床，修改en_ent_nb：患者就诊id：" + id_ent + "，分离时间：" + EnAppUtils.getServerDateTime());
		}else{
			EnLogUtil.getInstance().logError("母婴合床，修改en_ent_nb：患者就诊id：" + id_ent + "，合并时间：" + EnAppUtils.getServerDateTime());
		}
		return newBornDO;
	}
	
	/**
     * 批量获取新生儿记录,fanlq-2019-06-10
     * @param entId
     * @return
     * @throws BizException 
     */
    public Map<String,NewbornDO> getNbDOByEntList(List<String> entIds) throws BizException{
    	if (entIds == null || entIds.size() <= 0) {
			return null;
		}
    	Map<String,NewbornDO> map = new HashMap<String,NewbornDO>();
		SqlBuildHelper sqlBuilder = new SqlBuildHelper();
		sqlBuilder.append(" select nb.* ");
		sqlBuilder.append(" from en_ent_ip ip ");
		sqlBuilder.append(" inner join en_ent_nb nb");
		sqlBuilder.append(" on ip.id_ent = nb.id_ent_bb");
		sqlBuilder.append("	where ip.fg_newborn ='Y'");
		sqlBuilder.append("	and "+SqlUtils.getInSqlByBigIds("ip.id_ent", entIds.toArray(new String[0])));
		@SuppressWarnings("unchecked")
		List<NewbornDO> result = (List<NewbornDO>) new DAFacade().execQuery(sqlBuilder.toString(),new BeanListHandler(NewbornDO.class));
		if (ListUtil.isEmpty(result)) {
			return null;
		}else{
			for(NewbornDO newbornDO : result){
				if(!map.containsKey(newbornDO.getId_ent_bb())){
					map.put(newbornDO.getId_ent_bb(), newbornDO);
				}
			}
		}
		return map;
    }
}
