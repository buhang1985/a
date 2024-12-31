package iih.ci.ord.s.bp.skintest;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.StringUtils;
import iih.bd.srv.srvskintestrel.d.SrvSkinTestRelDO;
import iih.ci.ord.dto.skintest.d.LimitDurg;
import iih.ci.ord.dto.skintest.d.SkinTest;
import iih.ci.ord.pub.CiOrdUtils;
import iih.pi.overview.overview.d.PiPatAlDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @code 过敏史分类管理 相关逻辑处理BP
 * @author LiYue
 * @date 2019年5月7日,下午4:37:57
 */
public class Management0fAllergyHistoryBP {

	/**
	 * 
	 * @code 过敏史限制开立药品
	 * @author LiYue
	 * @date 2019年5月8日,上午10:39:12
	 * @param id_org
	 * @param id_pat
	 * @param Id_mm
	 * @return
	 * @throws BizException 
	 */
	public LimitDurg[] exec(PiPatAlDO[] piPatAll) throws BizException {
			
		// 过敏史非空校验
		if (CiOrdUtils.isEmpty(piPatAll))
			return null;
		
		// 限制过敏分类
		List<PiPatAlDO> limitPiPatAlDOList = new ArrayList<>();
		
		// 不限制过敏分类
		List<PiPatAlDO> NoLimitPiPatAlDOlist = new ArrayList<>();
		
		// 获取对应药品开立控制方式参数 (0限制开立 9不限制)
		GetAllergicHisHandleModeBP modebp = new GetAllergicHisHandleModeBP();
		piPatAll = modebp.getDrugOpeningControl(piPatAll);
		
		for (PiPatAlDO PatAlDO : piPatAll) {

			// 0限制开立
			if ("0".equals(PatAlDO.getId_datasrc()) && (!StringUtils.isNullOrEmpty(PatAlDO.getId_alcla()))) {
				limitPiPatAlDOList.add(PatAlDO);

			} else if (StringUtils.isNullOrEmpty(PatAlDO.getId_datasrc()) ||"9".equals(PatAlDO.getId_datasrc()) || (StringUtils.isNullOrEmpty(PatAlDO.getId_alcla()))) {
				NoLimitPiPatAlDOlist.add(PatAlDO);
			}
		}

		//皮试项目过敏分类反向查他所有的皮试项目
		List<SkinTest> SkinTest = getLimitsrv(limitPiPatAlDOList);
		
		//加上不限制过敏分类的皮试项目 
		if(!CiOrdUtils.isEmpty(NoLimitPiPatAlDOlist)) {
			for (PiPatAlDO piPatAlDO : NoLimitPiPatAlDOlist) {
				 SkinTest test = new  SkinTest();
				 test.setId_mm( piPatAlDO.getId_mm());
				 test.setId_srv(piPatAlDO.getId_srv());
				 SkinTest.add(test);
			}
		}
		
		
		//获取该皮试对应的所有药品
		List<LimitDurg> LimitDurg = getLimitDurglist(SkinTest);
		
		return LimitDurg.toArray(new LimitDurg[0]);
	}
	
	
    /**
     * @code 获取该皮试对应的所有项目
     * @author LiYue
     * @date 2019年5月8日,下午1:10:44
     * @param allpipatallergy
     * @return
     * @throws BizException 
     */
	private List<LimitDurg> getLimitDurglist(List<SkinTest> skinTestlist) throws BizException {
		
    String idmms = "";
    String idsrvs = "";
    //原液皮试限制的药品
    List<LimitDurg> LimitDurgList = new ArrayList<>();
    for (SkinTest skinTest : skinTestlist) {
		//id_mm为空的 用id_srv查
    	if(!StringUtils.isNullOrEmpty(skinTest.getId_srv())) {
    		idsrvs += "'"+skinTest.getId_srv()+"',";
    	}
    	if( !StringUtils.isNullOrEmpty(skinTest.getId_mm())){
    		idmms += "'"+skinTest.getId_mm()+"',";
    		LimitDurg durg = new LimitDurg();
    		durg.setId_mm(skinTest.getId_mm());
    		LimitDurgList.add(durg);
    	}
	}
		// 限制皮试查询对应的药品集合
		for (LimitDurg limitDurg : getLimitDrug(idsrvs, idmms)) {
			LimitDurgList.add(limitDurg);
		}
		 
		 return LimitDurgList;
	}
 
	//查询限制药品
	private List<LimitDurg> getLimitDrug(String idsrvs, String idmms) throws BizException {
		
		List<LimitDurg> durgList = null;
		
		String sql ="select id_mm from bd_mm where 1=1 ";
		//idsrvs，idmms都拼接
		if(!StringUtils.isNullOrEmpty(idsrvs)) {
			sql += "and id_srvskin  in ("+idsrvs+"'')";
			if(!StringUtils.isNullOrEmpty(idmms)) {
				sql += " or id_mmskin  in ("+idmms+"'')";
			}
		//idmms拼接一个	
		}else if(!StringUtils.isNullOrEmpty(idmms))
		{
			sql += " and id_mmskin  in ("+idmms+"'')";
		//空参拼接false	
		}else {
			sql += " and 1=2 ";
		}
		
		try {
			durgList = (List<LimitDurg>) new DAFacade().execQuery(sql, new BeanListHandler(LimitDurg.class));
		} catch (DAException e) {
			throw new  BizException(sql+"对应的药品获取失败");
		}
		    
		return durgList;
	}


	/**
	 * @code 皮试项目根据分类反向查他所有的皮试项目
	 * @author LiYue
	 * @date 2019年5月8日,下午1:11:02
	 * @param limitPiPatAlDOList
	 * @return
	 * @throws BizException 
	 */
	private List<SkinTest> getLimitsrv(List<PiPatAlDO> limitPiPatAlDOList) throws BizException {
		
		//有效性校验
		if(CiOrdUtils.isEmpty(limitPiPatAlDOList)) return new ArrayList();
		
		String id_alclas ="";
		
		for (PiPatAlDO piPatAlDO : limitPiPatAlDOList) {
			
			if(!StringUtils.isNullOrEmpty(piPatAlDO.getId_alcla())) {
				id_alclas += "'"+piPatAlDO.getId_alcla()+"',";
			}
		}
		return  getSrvSkinTestRelDO(id_alclas);
	}
	/**
	 * 
	 * @code 查该分类所有的皮试项目
	 * @author LiYue
	 * @date 2019年5月12日,下午10:36:27
	 * @param idmms
	 * @param idsrvs
	 * @return
	 * @throws BizException 
	 */
	private List<SkinTest> getSrvSkinTestRelDO(String id_alclas) throws BizException {
		List<SkinTest> SkinTestList = null;
		String sql ="	select id_srv,id_mm from BD_SRV_SKINTEST_REL where ";
		
		 if (!StringUtils.isNullOrEmpty(id_alclas)) {
			sql += "  id_altp  in (" + id_alclas + "'')";
		} else {
			sql += "  1=2 ";
		}
		
		try {
			SkinTestList =  (List<SkinTest>) new DAFacade().execQuery(sql,new BeanListHandler(SkinTest.class));
			} catch (Exception e) {
				throw new  BizException("对应皮试项目获取异常!   sql:"+sql);
			}
		return SkinTestList;
	}


	/**
	 * @code 通过Id_mm 查他所有的皮试项目
	 * @author LiYue
	 * @date 2019年5月8日,下午3:43:48
	 * @return
	 * @throws BizException 
	 */
	public List<SkinTest> getSrvSkinTestRelDOById_mm(String Id_mm) throws BizException{
		List<SkinTest> reldo = null;
		String sql ="select id_srv,id_mm from BD_SRV_SKINTEST_REL where id_mmca in( select ID_MMCA from BD_SRV_SKINTEST_REL where id_mm  = '"+Id_mm+"');";
		try {
			reldo =  (List<SkinTest>) new DAFacade().execQuery(sql,new BeanListHandler(SkinTest.class));
			} catch (Exception e) {
				throw new  BizException(Id_mm+"对应皮试项目获取异常");
			}
		return reldo;
		
	}
	
	/**
	 * @code 通过Id_srv 查他所有的皮试项目
	 * @author LiYue
	 * @date 2019年5月8日,下午3:43:48
	 * @return
	 * @throws BizException 
	 */
	public List<SkinTest> getSrvSkinTestRelDOById_srv(String id_srv) throws BizException{
		List<SkinTest> reldo = null;
		String sql ="	select id_srv,id_mm from BD_SRV_SKINTEST_REL where id_mmca in( select ID_MMCA from BD_SRV_SKINTEST_REL where id_srv  = '"+id_srv+"'";
		try {
			reldo =  (List<SkinTest>) new DAFacade().execQuery(sql,new BeanListHandler(SrvSkinTestRelDO.class));
			} catch (Exception e) {
				throw new  BizException(id_srv+"对应皮试项目获取异常!   sql:"+sql);
			}
		return reldo;
	}
	/**
	 * 
	 * @code 获取皮试对应的药品ById_mm
	 * @author LiYue
	 * @date 2019年5月9日,上午11:17:11
	 * @param Id_mm
	 * @return
	 * @throws BizException
	 */
	public List<LimitDurg> getLimitDrugById_mm(String Id_mm) throws BizException{
		List<LimitDurg> durgList = null;
		String sql ="select id_mm from bd_mm where id_mmskin = '"+Id_mm+"'";
		try {
			durgList = (List<LimitDurg>) new DAFacade().execQuery(sql, new BeanListHandler(LimitDurg.class));
		} catch (DAException e) {
			throw new  BizException(sql+"对应的药品获取失败");
		}
		return durgList;
	}
	/**
	 * 
	 * @code 获取皮试对应的药品ById_srv
	 * @author LiYue
	 * @date 2019年5月9日,上午11:16:41
	 * @param Id_srv
	 * @return
	 * @throws BizException
	 */
	public List<LimitDurg> getLimitDrugById_srv(String Id_srv) throws BizException{
		List<LimitDurg> durgList = null;
		String sql ="select id_mm from bd_mm where ID_SRVSKIN = '"+Id_srv+"'";
		try {
			durgList = (List<LimitDurg>) new DAFacade().execQuery(sql, new BeanListHandler(LimitDurg.class));
		} catch (DAException e) {
			throw new  BizException(sql+"对应的药品获取失败");
		}
		return durgList;
	}
	
	
}
