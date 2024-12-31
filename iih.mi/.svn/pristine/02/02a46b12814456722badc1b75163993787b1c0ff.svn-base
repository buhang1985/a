package iih.mi.bd.miudidoc.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.SqlUtils;
import iih.mi.bd.d.MiudidocDTO;
import iih.mi.bd.miudidoc.d.MiUdidocDO;
import iih.mi.bd.miudidoc.i.IMiudidocCudService;
import iih.mi.bd.miudidoc.i.IMiudidocRService;
import iih.mi.bd.miudidoclist.d.MiUdidoclistDO;
import iih.mi.bd.miudidoclist.i.IMiudidoclistRService;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FType;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.securityfw.login.d.PasswordUtil;

/**
 * 导入Excel数据
 * Title: ImportExcelDataBp.java
 * @author zhang.hw
 * @date 2019年5月22日  
 * @version 1.0
 */
public class ImportExcelDataBp {
	public void exec(MiudidocDTO[] miUdidocDOs,String idhp) throws BizException{
		
		if(ArrayUtil.isEmpty(miUdidocDOs)){
			return;
		}
		
		//插入数据
		this.insertDO(miUdidocDOs,idhp);
	}
	
	private void insertDO(MiudidocDTO[] miUdidocDTOs,String idhp) throws BizException{
		//档案类型
		List<String> miUdidocTpSet=new ArrayList();
		for (MiudidocDTO miUdidocDTO : miUdidocDTOs) {
			if(miUdidocTpSet.size()==0){
				miUdidocTpSet.add(miUdidocDTO.getCtrl1());
				continue;
			}				
			for(int i=0;i<miUdidocTpSet.size();i++){
				if(i==miUdidocTpSet.size()-1&&!miUdidocTpSet.get(i).equals(miUdidocDTO.getCtrl1())){
					miUdidocTpSet.add(miUdidocDTO.getCtrl1());
					break;
				}
				if(miUdidocTpSet.get(i).equals(miUdidocDTO.getCtrl1())){
					break;
				}
			}
		}
		IMiudidoclistRService miUdidoctpService=ServiceFinder.find(IMiudidoclistRService.class);
		String sql = SqlUtils.getInSqlByIds(MiUdidoclistDO.CODE, miUdidocTpSet);
		MiUdidoclistDO[] miUdidocTpArr = miUdidoctpService.find(sql,"",FBoolean.FALSE);
		if(ArrayUtil.isEmpty(miUdidocTpArr)){
			throw new BizException("未查询到对应的医保档案类型");
		}
		Map<String, MiUdidoclistDO> miUdidocTpMap=new HashMap<>();
		for (MiUdidoclistDO miUdidocTpDO : miUdidocTpArr) {
			miUdidocTpMap.put(miUdidocTpDO.getName(), miUdidocTpDO);
		}
		int length = 0;
		for(MiudidocDTO miudidocDTO:miUdidocDTOs){
			if (!"".equals(miudidocDTO.getCtrl2())) {
				length++;
			}
		}
		MiUdidocDO[] miUdidocDOs = new MiUdidocDO[length];
		
		for (int i=0;i<miUdidocDTOs.length;i++) {
			if("".equals(miUdidocDTOs[i].getCtrl2())){
				break;
			}
			MiUdidocDO miUdidocDO = new MiUdidocDO();
			miUdidocDO.setId_grp(Context.get().getGroupId());
			miUdidocDO.setId_org(Context.get().getOrgId());
			MiUdidoclistDO cardTp = miUdidocTpMap.get(miUdidocDTOs[i].getCtrl2());
			if(cardTp==null){
				throw new BizException("未查询到"+miUdidocDTOs[i].getCtrl2()+"对应的医保档案类型");
			}
			miUdidocDO.setId_miudidoclist(cardTp.getId_miudidoclist());
			miUdidocDO.setId_hp(idhp);
			miUdidocDO.setCode(miUdidocDTOs[i].getCode());
			miUdidocDO.setName(miUdidocDTOs[i].getName());
			miUdidocDO.setMnecode(miUdidocDTOs[i].getCode());
			miUdidocDO.setDes(miUdidocDTOs[i].getCtrl3());
			miUdidocDO.setPycode(CnToPy.getPyFirstCode(miUdidocDTOs[i].getName(), 100));// 拼音码
			miUdidocDO.setWbcode(CnToWB.getWBCode(miUdidocDTOs[i].getName(), 100));// 五笔码
			miUdidocDO.setStatus(DOStatus.NEW);
			miUdidocDOs[i] = miUdidocDO;
		}
		
		IMiudidocCudService miUdidocCudService=ServiceFinder.find(IMiudidocCudService.class);
		miUdidocCudService.save(miUdidocDOs);
	}
	
}
