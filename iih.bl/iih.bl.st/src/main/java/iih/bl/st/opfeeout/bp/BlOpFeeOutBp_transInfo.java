package iih.bl.st.opfeeout.bp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.hp.d.HPDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.st.dto.d.BlOpFeeOutDTO;
import iih.bl.st.dto.d.BlOpFeeOutFileDTO;
import iih.bl.st.dto.d.BlStItemInfoDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医保上传：第二部分本次交易信息内容
 * @author tcy
 *
 */
public class BlOpFeeOutBp_transInfo {
	/**
	 * 收费信息
	 * @throws BizException 
	 * */
	public 	BlOpFeeOutFileDTO[] getBlOpFeeOutFileInfos(BlOpFeeOutDTO[] blOpFeeOutDTOArr) throws BizException{
		
		Map<String,PatDO> pat_idPatDOMap=new HashMap<String,PatDO>();//《id_pat,patdo》
		Map<String,PatDO> id_entHpDOMap=new HashMap<String,PatDO>();//《id_ent,hpdo》
		Map<String,Integer> is_stoepCountMap=new HashMap<String,Integer>();//《结算主键id_stoep,结算明细int>
		IPatiMDORService iPatiMDORService=ServiceFinder.find(IPatiMDORService.class);
		StringBuffer sqlb=null;
		PatDO patDO=null;
		HPDO hpDO=null;
		String cond1="";
		String org_code="21110131";//先固化吧，北大国际医院医疗机构代码
		//1.获得门诊收费流水号
		FDateTime fDateTime =AppUtils.getServerDateTime();
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormater.format(new Date()) + "%";
		String dt_b= dateFormater.format(new Date()) +" 00:00:00";//结算开始日期 杨扬：处理一下，今日从00:00:00开始
		String dt_e= dateFormater.format(new Date()) +" 23:59:59";//结算结束日期 杨扬：处理一下，今日从23:59:59开始
		Integer count=0;//门诊明细数量
		String id_stoep="";
		String Code_st="";
		FDouble amt_idstoep=new FDouble(0);
		ColumnHandler handler = new ColumnHandler();
		DAFacade dAFacade = new DAFacade();
		List<BlOpFeeOutFileDTO> blOpFeeOutFileDTOLst=new ArrayList<BlOpFeeOutFileDTO>();
		//List<BlStItemInfoDTO> BlStItemInfoDTOLst=new ArrayList<BlStItemInfoDTO>();
		for(BlOpFeeOutDTO blOpFeeOutDTO : blOpFeeOutDTOArr)
		{
			//1。获得患者基本信息
			if(pat_idPatDOMap.containsKey(blOpFeeOutDTO.getId_pat()))
			{
				patDO=pat_idPatDOMap.get(blOpFeeOutDTO.getId_pat());
			}
			else
			{
				//cond1=" id_pat='"+blOpFeeOutDTO.getId_pat()+"' and sd_idtp='01' ";
				cond1=" id_pat='"+blOpFeeOutDTO.getId_pat()+"'";
				PatDO[] patDOs=iPatiMDORService.find(cond1, "", FBoolean.FALSE);
				patDO=patDOs[0];
				pat_idPatDOMap.put(blOpFeeOutDTO.getId_pat(), patDO);
			}
			//2.获得医疗机构代码 orgdo.code，先固化吧
			
			//3.门诊明细数量
			sqlb=new StringBuffer();
			sqlb.append("select count(x.id_cgitmoep) quan,x.id_stoep");
			sqlb.append("  from bl_cg_itm_oep x");
			sqlb.append(" inner join en_ent_hp xx");
			sqlb.append("    on x.id_ent = xx.id_ent");
			sqlb.append(" inner join bl_st_oep y");
			sqlb.append("    on x.id_stoep = y.id_stoep");
			sqlb.append(" inner join bl_prop_oep z");
			sqlb.append("    on y.id_stoep = z.id_stoep");
			sqlb.append(" where y.id_pat = ?");
			sqlb.append("   and y.dt_st >= to_char(?)");
			sqlb.append("   and y.dt_st <= to_char(?)");
			sqlb.append("   and y.eu_direct=1 and y.fg_canc='N'");//排除退费的
			sqlb.append("   group by x.id_stoep");
			SqlParam sqlp=new SqlParam();
			sqlp.addParam(blOpFeeOutDTO.getId_pat());
			sqlp.addParam(dt_b);
			sqlp.addParam(dt_e);	    	
			List<BlCgItmOepDO> BlCgItmOepDOLst1=(List<BlCgItmOepDO>)dAFacade.execQuery(sqlb.toString(),sqlp,  new BeanListHandler(BlCgItmOepDO.class));
			if(BlCgItmOepDOLst1==null || BlCgItmOepDOLst1.size()==0)
			{
				continue;
			}
			for(BlCgItmOepDO blCgItmOepDO:BlCgItmOepDOLst1) //此处含义不是明细表，而是结算主键，对应的明细条数，只是不再建立DTO
			{
				is_stoepCountMap.put(blCgItmOepDO.getId_stoep(), Integer.valueOf(blCgItmOepDO.getQuan().toString()));
			}

			
	    	//4.门诊发票金额及其总金额
	    	sqlb=new StringBuffer();
	    	sqlb.append("select sum(x.amt_std) amt_std,x.code_inccaitm,x.name_inccaitm,x.id_stoep");
	    	sqlb.append("  from bl_cg_itm_oep x");
	    	sqlb.append(" inner join en_ent_hp xx");
	    	sqlb.append("    on x.id_ent = xx.id_ent");
	    	sqlb.append(" inner join bl_st_oep y");
	    	sqlb.append("   on x.id_stoep = y.id_stoep");
	    	sqlb.append(" inner join bl_prop_oep z");
	    	sqlb.append("    on y.id_stoep = z.id_stoep");
	    	sqlb.append(" where y.id_pat = ?");
	    	sqlb.append("   and y.dt_st >= to_char(?)");
	    	sqlb.append("   and y.dt_st <= to_char(?)");
	    	sqlb.append("   and y.eu_direct=1 and y.fg_canc='N'  ");
	    	sqlb.append("  group by x.code_inccaitm,x.name_inccaitm,x.id_stoep");
	    	List<BlCgItmOepDO> BlCgItmOepDOLst=(List<BlCgItmOepDO>)dAFacade.execQuery(sqlb.toString(),sqlp,  new BeanListHandler(BlCgItmOepDO.class));
			if(BlCgItmOepDOLst==null || BlCgItmOepDOLst.size()==0)
			{
				continue;
			}
			Iterator iter1=is_stoepCountMap.entrySet().iterator();
			while (iter1.hasNext()) 
			{
				Map.Entry entry1 = (Map.Entry) iter1.next();
				if(!(new FDouble(entry1.getValue().toString()).compareTo(new FDouble(0))==0))
				{
					BlOpFeeOutFileDTO blOpFeeOutFileDTO=new BlOpFeeOutFileDTO();
					id_stoep=entry1.getKey().toString();
					count=Integer.getInteger(entry1.getValue().toString());
					List<BlStItemInfoDTO> BlStItemInfoDTOLst=new ArrayList<BlStItemInfoDTO>();
					FArrayList2 flist = new FArrayList2();
					amt_idstoep=new FDouble(0);
					for(BlCgItmOepDO blCgItmOepDO:BlCgItmOepDOLst) //此处含义不是明细表，而是归类后的表，只是不再建立DTO
					{
						if(id_stoep.equals(blCgItmOepDO.getId_stoep()))
						{
							BlStItemInfoDTO blStItemInfoDTO=new BlStItemInfoDTO();
							blStItemInfoDTO.setAmt(blCgItmOepDO.getAmt_std());
							blStItemInfoDTO.setName(blCgItmOepDO.getName_inccaitm());
							blStItemInfoDTO.setId_stoep(blCgItmOepDO.getId_stoep());
							BlStItemInfoDTOLst.add(blStItemInfoDTO);
							flist.add(blStItemInfoDTO);
							amt_idstoep=amt_idstoep.add(blCgItmOepDO.getAmt_std());
						}
					}
//					blOpFeeOutFileDTO.setBlstiteminfodtoarr(BlStItemInfoDTOLst.toArray(new BlStItemInfoDTO[0]));
					blOpFeeOutFileDTO.setBlstiteminfodtoarr(flist);
					blOpFeeOutFileDTO.setAmt(amt_idstoep);
					blOpFeeOutFileDTO.setId_stoep(id_stoep);
					blOpFeeOutFileDTO.setCode_st(Code_st);//杨扬：这个还没有查出来
					blOpFeeOutFileDTO.setCode_org(org_code);
					blOpFeeOutFileDTO.setId_card(patDO.getId_code());
					blOpFeeOutFileDTO.setName_pat(patDO.getName());
					blOpFeeOutFileDTO.setNumber(is_stoepCountMap.get(id_stoep));
					//杨扬：还差几个
					blOpFeeOutFileDTOLst.add(blOpFeeOutFileDTO);
				}
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		//2.获得
		
		return blOpFeeOutFileDTOLst.toArray(new BlOpFeeOutFileDTO[]{});
	}

}
