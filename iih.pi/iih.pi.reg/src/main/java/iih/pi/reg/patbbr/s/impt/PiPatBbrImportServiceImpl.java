package iih.pi.reg.patbbr.s.impt;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.patbbr.d.PiPatBbrDO;
import iih.pi.reg.patbbr.i.IPatbbrCudService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 患者不良记录导入类
 * @author ly 2017/07/11
 *
 */
public class PiPatBbrImportServiceImpl extends BaseDataImport<PiPatBbrDO> implements IDataImport {

	@Override
	public boolean checkNotNull() throws BizException {
		
		//1.取得数据
		PiPatBbrDO[] dos =  getDOsFromImportDB(new PiPatBbrDO(),"sd_bbrtp = '51' ",false);
		if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者不良记录(医保黑名单)导入数据为空！");
		
		//2.非空校验
    	checkNullValue(Arrays.asList(PiPatBbrDO.ID_PAT), dos);
		
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean importData() throws BizException {
		
		//1.取得数据
		PiPatBbrDO[] dos =  getDOsFromImportDB(new PiPatBbrDO(),"sd_bbrtp = '51' ",true);
		if (ArrayUtil.isEmpty(dos))
    		throw new BizException("患者不良记录(医保黑名单)导入数据为空！");
				
		//3.设置status
    	processDOs(dos);
    	
    	//4.设置患者id
    	List<String> idList  = new ArrayList<String>();
    	for (PiPatBbrDO bbr : dos) {
    		if(!StringUtil.isEmpty(bbr.getId_pat()) && bbr.getId_pat().length() != 20){
    			idList.add(bbr.getId_pat());//chis导入时患者证件号
    		}
    		//bbr.setId_patlock(null);
		}
    	
    	DAFacade daf = new DAFacade();
    	List<PatDO> pats = (List<PatDO>)daf.findByAttrValStrings(PatDO.class,PatDO.ID_CODE , idList.toArray(new String[0]), 
    			new String[]{PatDO.ID_PAT,PatDO.ID_CODE});
    	
    	if(!ListUtil.isEmpty(pats)){
    		Map<String,String> idKeyMap = new HashMap<String,String>();
    		for (PatDO patDO : pats) {
    			idKeyMap.put(patDO.getId_code(), patDO.getId_pat());
			}
    		
    		for (PiPatBbrDO bbr : dos) {
    			if(idKeyMap.containsKey(bbr.getId_pat())){
    				bbr.setId_pat(idKeyMap.get(bbr.getId_pat()));
    			}
			}
    	}
    	
    	//5.数据插入目标库
    	ServiceFinder.find(IPatbbrCudService.class).insert(dos);
    	
		return true;
	}
	
	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"pi_pat_bbr"};
	}
	
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from pi_pat_bbr where sd_bbrtp = '51'");//删除患者不良记录(医保黑名单)数据
		return true;
	}
}
