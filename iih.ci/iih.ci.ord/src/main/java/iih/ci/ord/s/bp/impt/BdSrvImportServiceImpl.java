package iih.ci.ord.s.bp.impt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDO2;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.utils.BdSrvParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

public class BdSrvImportServiceImpl extends BaseDataImport<MedSrvDO> implements IDataImport {

	@Override
	public boolean checkNotNull() throws BizException {
		// 1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		MedSrvDO[] dos = getDOsFromImportDB(new MedSrvDO(), "1=1", false);
		if (ArrayUtils.isEmpty(dos))
			throw new BizException("医疗服务导入数据为空！");

		// 2、名称编码校验
		checkNullValue(Arrays.asList(MedSrvDO.ID_SRV, MedSrvDO.NAME, MedSrvDO.CODE, MedSrvDO.ID_GRP, MedSrvDO.ID_ORG),
				dos);
		return true;
	}

	@Override
	public boolean importData() throws BizException {
		//从中间表得到update的数据
		MedSrvDO[] dosUpdate = getDOsFromUpdateDB(new MedSrvDO(), "1=1");
		if (!ArrayUtils.isEmpty(dosUpdate)){
			
			//处理DO状态为update
			processUpdateDOs(dosUpdate);

			// 5、调用框架的新增方法(其中包括管控唯一性校验等)更新目标库
			Map<String,List<MedSrvDO>> map=new HashMap<>();
			//medsrvdo按集团id和组织id分组
			for (MedSrvDO m : dosUpdate) {
				String key=m.getId_grp()+"_"+m.getId_org();
				if(!map.containsKey(key)) {
					List<MedSrvDO> list=new ArrayList<>();
					list.add(m);
					map.put(key, list);
				}else {
					List<MedSrvDO> list=map.get(key);
					list.add(m);
				}				
			}
			for (String key : map.keySet()) {
				List<MedSrvDO> list=map.get(key);
				//根据导入数据设置id_org和id_grp
				String[] ss=key.split("_");
				Context.get().setGroupId(ss[0].trim());
				Context.get().setOrgId(ss[1].trim());
				ServiceFinder.find(IMedsrvMDOCudService.class).update(list.toArray(new MedSrvDO[0]));
			}
			
		}
		// 从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		MedSrvDO[] dos = getDOsFromImportDB(new MedSrvDO(), "1=1", true);
		if (!ArrayUtils.isEmpty(dos)){			
			// 3、状态改为New
			processDOs(dos);
			
			// 调用框架的新增方法(其中包括管控唯一性校验等)插入目标库  ??   基础服务的校验不适用数据导入
			// ServiceFinder.find(IMedsrvMDOCudService.class).insert(dos);
			DAFacade daFacade = new DAFacade();
			daFacade.insertDOArrayWithPK(dos);
			DAFacade da = new DAFacade();
			da.execUpdate(
					"update bd_srv set srvca_innercode=(select innercode from bd_srvca where bd_srv.id_srvca = bd_srvca.id_srvca)");	
		}
		//throw new BizException("医疗服务导入数据为空！");
		return true;
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from " + new MedSrvDO().getTableName() + "" + " where "
				+ new MedSrvDO().getPKFieldName() + " not like '@@@@%'");
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[] { new MedSrvDO().getTableName() };
	}

	@Override
	public boolean checkBusiness() throws BizException {
		// 1、导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得

		DAFacade daFacade = new DAFacade();
//		FBoolean iscodeCheck=BdSrvParamUtils.getFgCheckSrvCodeLength();
		FBoolean iscodeCheck=FBoolean.FALSE;
		List<MedSrvDO2> doses = (List<MedSrvDO2>) daFacade.findByCond((new MedSrvDO2()).getClass(), " 1=1  ");
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (MedSrvDO2 medSrvDO2 : doses) {
			String med = medSrvDO2.toString();
			char[] sc = med.toCharArray();

			int k = 0;
			for (char c : sc) {
				if (c < 0x20 || c == 0x7F) {
					sb.append(medSrvDO2.getId_srv() + "," + getvalname(med, sc, k) + ";");
				}
				k++;
			}
			//0172738: BDSRV0007参数为false，还是检验了
			if(iscodeCheck!=null&&iscodeCheck.booleanValue()) {
			if (medSrvDO2 != null && (StringUtils.isEmpty(medSrvDO2.getCode()) || medSrvDO2.getCode().length() != 8)) {
				sb2.append(medSrvDO2.getName()+" 的编码："+ medSrvDO2.getCode()+",");
			}
			}

		}
		if (sb.length() > 0) {
			throw new BizException("IIH.CI.LC表[bd_srv] [id_srv]中的值为" + sb.toString() + "的数据存在不可见字符");
		}
		if (sb2.length() > 0) {
			throw new BizException(String.format("临床医疗服务项目\"%s\"的编码长度不是8位，请修正。", sb2.toString()));
		}

		
		return true;
	}
	

	private String getvalname(String med, char[] sc, int k) {

		StringBuilder sb = new StringBuilder();
		int j = 0;
		for (int i = k; i > 0; i--) {
			// sb.append(c + ",");
			if (sc[i] == '(' && sc[i - 1] == ':') {
				j = i - 1;
				break;
			}

		}

		for (int i = j - 1; i >= 0; i--) {
			// sb.append(c + ",");

			if (sc[i] == ',') {
				break;
			}
			sb.append(sc[i]);
		}
		return sb.reverse().toString();

	}

}
