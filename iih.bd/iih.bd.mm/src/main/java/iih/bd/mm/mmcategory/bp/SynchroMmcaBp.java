package iih.bd.mm.mmcategory.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.mm.mmcategory.i.IMmcategoryCudService;
import iih.bd.mm.mmcategory.i.IMmcategoryRService;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.srv.srvcate.i.ISrvcateRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class SynchroMmcaBp {
	
	public void exec() throws BizException {
		
		//父级数据同步
		this.synchroParSrvCa();
		
		//子级数据同步
		this.synchroSubSrvCa();
	}

	private void synchroParSrvCa() throws BizException {
		
		IMmcategoryRService mmcaRSrv = ServiceFinder.find(IMmcategoryRService.class);
		MMCategoryDO[] mmcaDOS = mmcaRSrv.find("nvl(id_parent, '~') = '~'", MMCategoryDO.CODE, FBoolean.TRUE);
		if(mmcaDOS == null || mmcaDOS.length <= 0) {
			
			return;
		}
		//医疗服务基本分类
		Map<String, SrvCateDO> srvcaMap = this.getSrvcaMap(mmcaDOS);
		
		List<MMCategoryDO> mmcaDOList = new ArrayList<MMCategoryDO>();
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			if(!srvcaMap.containsKey(mmcaDO.getCode())) {
				
				continue;
			}
			SrvCateDO[] srvcaDOS = this.getSrvCateDO(mmcaDO, srvcaMap.get(mmcaDO.getCode()));
			if(srvcaDOS == null || srvcaDOS.length <= 0) {
				
				continue;
			}
			for(SrvCateDO srvCateDO : srvcaDOS) {
				
				MMCategoryDO synchroMmcaDO = (MMCategoryDO)mmcaDO.clone();
				//基本分类主键
				synchroMmcaDO.setId_mmca(null);
				//集团
				synchroMmcaDO.setId_grp(Context.get().getGroupId());
				//机构
				synchroMmcaDO.setId_org(Context.get().getOrgId());
				//基本分类编码
				synchroMmcaDO.setCode(srvCateDO.getCode());
				//基本分类名称
				synchroMmcaDO.setName(srvCateDO.getName());
				//五笔
				synchroMmcaDO.setWbcode(null);
				//拼音
				synchroMmcaDO.setPycode(null);
				//助记码
				synchroMmcaDO.setMnecode(null);
				//描述
				synchroMmcaDO.setDes(null);
				//父级主键
				synchroMmcaDO.setId_parent(mmcaDO.getId_mmca());
				//内部编码
				synchroMmcaDO.setInnercode(null);
				//服务基本分类主键
				synchroMmcaDO.setId_srvca(srvCateDO.getId_srvca());
				//服务基本分类标识
				synchroMmcaDO.setFg_srvca(new FBoolean(true));
				//创建人
				synchroMmcaDO.setCreatedby(null);
				//创建时间
				synchroMmcaDO.setCreatedtime(null);
				//最后修改人
				synchroMmcaDO.setModifiedby(null);
				//最后修改时间
				synchroMmcaDO.setModifiedtime(null);
				
				mmcaDOList.add(synchroMmcaDO);
			}
		}
		
		if(mmcaDOList != null && mmcaDOList.size() > 0) {
			
			IMmcategoryCudService mmcaCudSrv = ServiceFinder.find(IMmcategoryCudService.class);
			mmcaCudSrv.insert(mmcaDOList.toArray(new MMCategoryDO[mmcaDOList.size()]));
		}
	}

	private Map<String, SrvCateDO> getSrvcaMap(MMCategoryDO[] mmcaDOS) throws BizException {
		
		ISrvcateRService srvcaRSrv = ServiceFinder.find(ISrvcateRService.class);
		
		Map<String, SrvCateDO> srvcaMap = new HashMap<String, SrvCateDO>();
		String[] codeList = this.getSrvcaCodeList(mmcaDOS);
		SrvCateDO[] srvCateList = srvcaRSrv.findByAttrValStrings(SrvCateDO.CODE, codeList);
		if(srvCateList == null || srvCateList.length <= 0) {
			
			return srvcaMap;
		}
		
		for(SrvCateDO srvcaDO : srvCateList) {
			
			srvcaMap.put(srvcaDO.getCode(), srvcaDO);
		}
		
		return srvcaMap;
	}

	private String[] getSrvcaCodeList(MMCategoryDO[] mmcaDOS) throws BizException {
		
		List<String> codeList = new ArrayList<String>();
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			codeList.add(mmcaDO.getCode());
		}
		
		return codeList.toArray(new String[codeList.size()]);
	}
	
	private SrvCateDO[] getSrvCateDO(MMCategoryDO mmcaDO, SrvCateDO srvCateDO) throws BizException {
		
		ISrvcateRService srvcaRSrv = ServiceFinder.find(ISrvcateRService.class);
		
		String whrStr = String.format("innercode like '%s%%' and code not in (select code from bd_mmca where innercode like '%s%%')"
				+ " and id_parent = '%s'", srvCateDO.getInnercode(), mmcaDO.getInnercode(), srvCateDO.getId_srvca());
		SrvCateDO[] srvCateList = srvcaRSrv.find(whrStr, "", FBoolean.TRUE);
		
		return srvCateList;
	}
	
	private void synchroSubSrvCa() throws BizException {
		
		IMmcategoryRService mmcaRSrv = ServiceFinder.find(IMmcategoryRService.class);
		MMCategoryDO[] mmcaDOS = mmcaRSrv.find("fg_srvca = 'Y'", MMCategoryDO.CODE, FBoolean.TRUE);
		if(mmcaDOS == null || mmcaDOS.length <= 0) {
			
			return;
		}
		//医疗服务基本分类获取
		Map<String, List<SrvCateDO>> srvcaMap = this.getSrvcaListMap(mmcaDOS);
		
		List<MMCategoryDO> mmcaDOList = new ArrayList<MMCategoryDO>();
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			if(!srvcaMap.containsKey(mmcaDO.getId_srvca())) {
				
				continue;
			}
			
			for(SrvCateDO srvCateDO : srvcaMap.get(mmcaDO.getId_srvca())) {
				
				MMCategoryDO synchroMmcaDO = (MMCategoryDO)mmcaDO.clone();
				//基本分类主键
				synchroMmcaDO.setId_mmca(null);
				//集团
				synchroMmcaDO.setId_grp(Context.get().getGroupId());
				//机构
				synchroMmcaDO.setId_org(Context.get().getOrgId());
				//基本分类编码
				synchroMmcaDO.setCode(srvCateDO.getCode());
				//基本分类名称
				synchroMmcaDO.setName(srvCateDO.getName());
				//五笔
				synchroMmcaDO.setWbcode(null);
				//拼音
				synchroMmcaDO.setPycode(null);
				//助记码
				synchroMmcaDO.setMnecode(null);
				//描述
				synchroMmcaDO.setDes(null);
				//父级主键
				synchroMmcaDO.setId_parent(mmcaDO.getId_mmca());
				//内部编码
				synchroMmcaDO.setInnercode(null);
				//服务基本分类主键
				synchroMmcaDO.setId_srvca(srvCateDO.getId_srvca());
				//服务基本分类标识
				synchroMmcaDO.setFg_srvca(new FBoolean(true));
				//创建人
				synchroMmcaDO.setCreatedby(null);
				//创建时间
				synchroMmcaDO.setCreatedtime(null);
				//最后修改人
				synchroMmcaDO.setModifiedby(null);
				//最后修改时间
				synchroMmcaDO.setModifiedtime(null);
				
				mmcaDOList.add(synchroMmcaDO);
			}
		}
		
		if(mmcaDOList != null && mmcaDOList.size() > 0) {
			
			IMmcategoryCudService mmcaCudSrv = ServiceFinder.find(IMmcategoryCudService.class);
			mmcaCudSrv.insert(mmcaDOList.toArray(new MMCategoryDO[mmcaDOList.size()]));
		}
	}

	private Map<String, List<SrvCateDO>> getSrvcaListMap(MMCategoryDO[] mmcaDOS) throws BizException {
		
		ISrvcateRService srvcaRSrv = ServiceFinder.find(ISrvcateRService.class);
		
		Map<String, List<SrvCateDO>> result = new HashMap<String, List<SrvCateDO>>();
		String[] parIdList = this.getSrvcaParIdList(mmcaDOS);
		SrvCateDO[] srvCateList = srvcaRSrv.findByAttrValStrings(SrvCateDO.ID_PARENT, parIdList);
		if(srvCateList == null || srvCateList.length <= 0) {
			
			return result;
		}
		
		for(SrvCateDO srvcaDO : srvCateList) {
			
			if(result.containsKey(srvcaDO.getId_parent())) {
				
				List<SrvCateDO> srvcaDOS = result.get(srvcaDO.getId_parent());
				srvcaDOS.add(srvcaDO);
			} else {
				
				List<SrvCateDO> srvcaDOS = new ArrayList<SrvCateDO>();
				srvcaDOS.add(srvcaDO);
				result.put(srvcaDO.getId_parent(), srvcaDOS);
			}
		}
		
		return result;
	}

	private String[] getSrvcaParIdList(MMCategoryDO[] mmcaDOS) throws BizException {
		
		List<String> parIdList = new ArrayList<String>();
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			parIdList.add(mmcaDO.getId_srvca());
		}
		
		return parIdList.toArray(new String[parIdList.size()]);
	}
}
