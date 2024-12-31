package iih.ci.ord.s.bp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.ord.dto.blexorder.d.DiagTreatKeyPointRntDataDTO;
import iih.ci.ord.dto.blexorder.d.DiagTreatViewRntDataDTO;
import iih.ci.ord.dto.blexorder.d.OrGenSplitTpEnum;
import iih.ci.ord.dto.blexorder.d.OrLongTempEnum;
import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.TransSrvSplitOrderDTO;
import iih.ci.ord.s.bp.orsrvsplit.GetOrAndSrvSplitSqlRsBP;
import iih.mp.nr.foreign.d.GetTemDataParamDTO;
import iih.mp.nr.foreign.i.IForeignService;
import iih.mp.nr.temperaturechart.d.Temcharitemdto;
import iih.nmr.pkuf.dto.nmrlist.d.NmrListDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.desc.UdidocDODesc;
import xap.sys.xbd.udi.i.IUdidocRService;

public class getDiagTreatKeyPointDataBP {

	private IUdidocRService service = ServiceFinder.find(IUdidocRService.class);
	private Map<String, List<UdidocDO>> map = new HashMap<>();
	
	public DiagTreatViewRntDataDTO exe(OrSrvSplitParamDTO orparams) throws BizException {
		DiagTreatViewRntDataDTO keyrnt=new DiagTreatViewRntDataDTO();
		getDiagTreatViewDataBP bp=new getDiagTreatViewDataBP();
		DiagTreatViewRntDataDTO rnt=bp.exe(orparams);
		FArrayList2 temp1 = rnt.getClinicalevents();
		List<FDate> result=new ArrayList<>();
		Map<String,Object> map=new HashMap<>();
		if(temp1!=null) {
			for (Object o : temp1) {
				Temcharitemdto t=(Temcharitemdto)o;
				if(t.getCode_event()!=null) {
					String key=t.getLogtime().getDate().toString();
					if(!map.containsKey(key)) {
						map.put(key, t);
					    result.add(t.getLogtime().getDate());
					}
				}
			}
		}
//		result.sort(new Comparator<FDate>() {
//
//			@Override
//			public int compare(FDate o1, FDate o2) {
//				// TODO Auto-generated method stub
//				if(o1.after(o2))
//					return 1;
//				if(o2.after(o1))
//					return -1;
//				return 0;
//			}
//		});

		
		//过滤用药数据
		FArrayList2 fa2=new FArrayList2();
        FArrayList2 fa=rnt.getDrugdata();

        for (Object o : fa) {
        	TransSrvSplitOrderDTO t=(TransSrvSplitOrderDTO)o;
        	
//        	if(t.getDt_mp_plan().getDate().before(result.get(0))&&t.getDt_mp_plan().getDate().after(result.get(result.size()-1))){
//        		continue;
//        	}else {
//        		for (FDate f : result) {
//					if(f.isSameDate(t.getDt_mp_plan().getDate())) {
//						fa2.add(t);
//						break;
//					}
//				}
//        	}
    		for (FDate f : result) {
				if(f.isSameDate(t.getDt_mp_plan().getDate())) {
					fa2.add(t);
					break;
				}
			}
		}
        keyrnt.setDrugdata(fa2);
        //过滤检验数据
         fa2=new FArrayList2();
         fa=rnt.getLabdata();
        for (Object o : fa) {
        	OrSplitOrderDTO t=(OrSplitOrderDTO)o;
        	
//        	if(t.getDt_effe().getDate().before(result.get(0))&&t.getDt_effe().getDate().after(result.get(result.size()-1))){
//        		continue;
//        	}else {
//        		for (FDate f : result) {
//					if(f.isSameDate(t.getDt_effe().getDate())) {
//						fa2.add(t);
//						break;
//					}
//				}
//        	}
        	for (FDate f : result) {
				if(f.isSameDate(t.getDt_effe().getDate())) {
					fa2.add(t);
					break;
				}
			}
		}
        keyrnt.setLabdata(fa2);
        //过滤检查数据
        fa2=new FArrayList2();
        fa=rnt.getObsdata();
       for (Object o : fa) {
       	OrSplitOrderDTO t=(OrSplitOrderDTO)o;
       	
//       	if(t.getDt_effe().getDate().before(result.get(0))&&t.getDt_effe().getDate().after(result.get(result.size()-1))){
//       		continue;
//       	}else {
//       		for (FDate f : result) {
//					if(f.isSameDate(t.getDt_effe().getDate())) {
//						fa2.add(t);
//						break;
//					}
//				}
//       	}
       	for (FDate f : result) {
			if(f.isSameDate(t.getDt_effe().getDate())) {
				fa2.add(t);
				break;
			}
		}
		}
       keyrnt.setObsdata(fa2);
       //过滤病历数据
       fa2=new FArrayList2();
       fa=rnt.getCimrs();
      for (Object o : fa) {
    	  CiMrDO t=(CiMrDO)o;
      	
//      	if(t.getDt_rd().getDate().before(result.get(0))&&t.getDt_rd().getDate().after(result.get(result.size()-1))){
//      		continue;
//      	}else {
//      		for (FDate f : result) {
//					if(f.isSameDate(t.getDt_rd().getDate())) {
//						fa2.add(t);
//						break;
//					}
//				}
//      	}
  		for (FDate f : result) {
				if(f.isSameDate(t.getDt_rd().getDate())) {
					fa2.add(t);
					break;
				}
			}
		}
      keyrnt.setCimrs(fa2);
      keyrnt.setMrctmcas(rnt.getMrctmcas());
      
      //过滤待书写文书
      fa2=new FArrayList2();
      fa=rnt.getMrtasks();
      for(Object o:fa) {
    	  MrTaskDO t=(MrTaskDO)o;
    		for (FDate f : result) {
  				if(f.isSameDate(t.getDt_begin().getDate())) {
  					fa2.add(t);
  					break;
  				}
  			}
      }
      keyrnt.setMrtasks(fa2);
      
      //过滤护理文书数据
      fa2=new FArrayList2();
      fa=rnt.getNmrdata();
     for (Object o : fa) {
    	 NmrListDTO t=(NmrListDTO)o;
     	
//     	if(t.getDt_create().getDate().before(result.get(0))&&t.getDt_create().getDate().after(result.get(result.size()-1))){
//     		continue;
//     	}else {
//     		for (FDate f : result) {
//					if(f.isSameDate(t.getDt_create().getDate())) {
//						fa2.add(t);
//						break;
//					}
//				}
//     	}
 		for (FDate f : result) {
				if(f.isSameDate(t.getDt_create().getDate())) {
					fa2.add(t);
					break;
				}
			}
		}
     keyrnt.setNmrdata(fa2);
     
     //设置临床事件
     keyrnt.setClinicalevents(rnt.getClinicalevents());
     
     //过滤生命体征数据
     fa2=new FArrayList2();
     fa=rnt.getBodysignsdata();
     
    for (Object o : fa) {
    	Temcharitemdto t=(Temcharitemdto)o;
    	
//    	if(t.getLogtime().getDate().before(result.get(0))&&t.getLogtime().getDate().after(result.get(result.size()-1))){
//    		continue;
//    	}else {
//    		for (FDate f : result) {
//					if(f.isSameDate(t.getLogtime().getDate())) {
//						fa2.add(t);
//						break;
//					}
//				}
//    	}
    	for (FDate f : result) {
			if(f.isSameDate(t.getLogtime().getDate())) {
				fa2.add(t);
				break;
			}
		}
		}
    keyrnt.setBodysignsdata(fa2);
	  return keyrnt;
	}

	public DiagTreatKeyPointRntDataDTO[] exe_old(String id_en, FDateTime start, FDateTime end) throws BizException {

		IForeignService foreignservice = ServiceFinder.find(IForeignService.class);
		splitOrSplitSqlRsBP orbp = new splitOrSplitSqlRsBP();
		splitSrvSplitSqlRsBP srvbp = new splitSrvSplitSqlRsBP();
		setUdidocs();
		List<FDate> fl=new ArrayList<>();
		List<DiagTreatKeyPointRntDataDTO> rntlist = new ArrayList<>();
		Map<String, DiagTreatKeyPointRntDataDTO> dmap=new HashMap<>();
		DiagTreatKeyPointRntDataDTO tmpkey=new DiagTreatKeyPointRntDataDTO();
		tmpkey.setDt_keypoint(start.getDate());
		dmap.put(start.getDate().toString(), tmpkey);
		fl=getdatelist(fl,start.getDate());
		// 检验拆分数据
		OrSrvSplitParamDTO labparam = new OrSrvSplitParamDTO();
		labparam.setId_ens(id_en);
		labparam.setDt_split_start(start);
		labparam.setDt_split_end(end);
		labparam.setEu_orlongtemp(OrLongTempEnum.ALL);
		labparam.setEu_orgensplittp(OrGenSplitTpEnum.SPLITBYOR);
		labparam.setSd_srvtps(getSrvStr("lab"));
		OrSplitOrderDTO[] labdtos = orbp.exec(labparam);
//		FArrayList2 labfa = new FArrayList2();
//		if (labdtos != null)
//			Collections.addAll(labfa, labdtos);
//		rntdto.setLabdata(labfa);
		//按日期分类
		for (OrSplitOrderDTO o : labdtos) {

			FDate a=o.getDt_mp_plan().getDate();
			if(dmap.containsKey(a.toString())){
				DiagTreatKeyPointRntDataDTO tmp = dmap.get(a.toString());
				FArrayList2 labfa =tmp.getLabdata();
				labfa.add(o);

			}else{
				DiagTreatKeyPointRntDataDTO tmp = new DiagTreatKeyPointRntDataDTO();
				tmp.setDt_keypoint(a);
				FArrayList2 labfa = new FArrayList2();
				labfa.add(o);
				tmp.setLabdata(labfa);
				dmap.put(a.toString(), tmp);
				fl=getdatelist(fl,a);
			}
		}
		
		// 检查拆分数据
		OrSrvSplitParamDTO obsparam = new OrSrvSplitParamDTO();
		obsparam.setId_ens(id_en);
		obsparam.setDt_split_start(start);
		obsparam.setDt_split_end(end);
		obsparam.setEu_orlongtemp(OrLongTempEnum.ALL);
		obsparam.setEu_orgensplittp(OrGenSplitTpEnum.SPLITBYOR);
		obsparam.setSd_srvtps(getSrvStr("obs"));
		OrSplitOrderDTO[] obsdtos = orbp.exec(obsparam);
//		FArrayList2 obsfa = new FArrayList2();
//		if (obsdtos != null)
//			Collections.addAll(obsfa, obsdtos);
//		rntdto.setObsdata(obsfa);
		
		//按日期分类
		for (OrSplitOrderDTO o : obsdtos) {

			FDate a=o.getDt_mp_plan().getDate();
			if(dmap.containsKey(a.toString())){
				DiagTreatKeyPointRntDataDTO tmp = dmap.get(a.toString());
				FArrayList2 labfa =tmp.getObsdata();
				labfa.add(o);
				
			}else{
				DiagTreatKeyPointRntDataDTO tmp = new DiagTreatKeyPointRntDataDTO();
				tmp.setDt_keypoint(a);
				FArrayList2 labfa = new FArrayList2();
				labfa.add(o);
				tmp.setObsdata(labfa);
				dmap.put(a.toString(), tmp);
				fl=getdatelist(fl,a);
			}
		}
		// 生命体征数据
		GetTemDataParamDTO tmpparam = new GetTemDataParamDTO();
		tmpparam.setId_ent(id_en);
		tmpparam.setDt_begin(start);
		tmpparam.setDt_end(end);
		tmpparam.setFg_temsheet(FBoolean.TRUE);
		Temcharitemdto[] temp1 = foreignservice.getTemData(tmpparam);

		//按日期分类
		for (Temcharitemdto o : temp1) {

			FDate a=o.getLogtime().getDate();
			if(dmap.containsKey(a.toString())){
				DiagTreatKeyPointRntDataDTO tmp = dmap.get(a.toString());
				FArrayList2 labfa =tmp.getBodysignsdata();
				if(labfa==null){
					labfa=new FArrayList2();
					tmp.setBodysignsdata(labfa);
				}
				labfa.add(o);	
				
			}
		}
		//获取药品数据
		OrSrvSplitParamDTO srvparam = new OrSrvSplitParamDTO();
		srvparam.setId_ens(id_en);
		srvparam.setDt_split_start(start);
		srvparam.setDt_split_end(end);
		srvparam.setEu_orlongtemp(OrLongTempEnum.ALL);
		srvparam.setEu_orgensplittp(OrGenSplitTpEnum.SPLITBYSRVMM);
		srvparam.setSd_srvtps(getSrvStr("drug"));
		GetOrAndSrvSplitSqlRsBP getsrvbp=new GetOrAndSrvSplitSqlRsBP();	
        BaseDTO[] splitDTO=getsrvbp.exec(srvparam);
        List<BaseDTO> slist=new ArrayList<>();
    //    FDate[] farray= getdatelist(fl);
        //根据关键点过滤
        for (BaseDTO o : splitDTO) {
        	SrvSplitOrderDTO s=(SrvSplitOrderDTO)o;
        	if(s.getDt_effe().after(fl.get(fl.size()-1))||(s.getDt_stop()==null&&s.getDt_end().before(fl.get(0)))||(s.getDt_stop()!=null&&s.getDt_stop().before(fl.get(0))))continue;
        	boolean flag=true;
        	for(int i=0;i<fl.size();i++){
        		
        		if(s.getDt_effe().getDate().compareTo(fl.get(i))>0&&((s.getDt_stop()==null&&s.getDt_end().getDate().compareTo(fl.get(i+1))<0)||(s.getDt_stop()!=null&&s.getDt_stop().getDate().compareTo(fl.get(i+1))<0) )){
        			flag=false;
        			break;
        		}else if((s.getDt_effe().getDate().compareTo(fl.get(i))<=0)&&(s.getDt_stop()==null&&(s.getDt_end().getDate().compareTo(fl.get(i))>=0))||(s.getDt_stop()!=null&&(s.getDt_stop().getDate().compareTo(fl.get(i))>=0))){
        			break;
        		}
        	}
        	if(flag)
        		slist.add(o);
		}
        
        //获取药品拆分数据
        DiagTreatsplitSrvSplitSqlRsBP splitp=new DiagTreatsplitSrvSplitSqlRsBP();
        if(slist.size()>0){
        	SrvSplitOrderDTO[] srvsplits=splitp.exec(slist.toArray(new SrvSplitOrderDTO[0]), srvparam);
        	////按日期分类
        	for (SrvSplitOrderDTO srvSplitOrderDTO : srvsplits) {
        		FDate a=srvSplitOrderDTO.getDt_mp_plan().getDate();
    			if(dmap.containsKey(a.toString())){
    				DiagTreatKeyPointRntDataDTO tmp = dmap.get(a.toString());
    				FArrayList2 labfa =tmp.getDrugdata();
    				if(labfa==null){
    					labfa=new FArrayList2();
    					tmp.setDrugdata(labfa);
    				}
    				labfa.add(srvSplitOrderDTO);	
    				
    			}
			}
        }
        //数据组装
        for (FDate fDate : fl) {
        	rntlist.add(dmap.get(fDate.toString()));
		}
		return rntlist.toArray(new DiagTreatKeyPointRntDataDTO[0]);

	}
   /**
    * 排序
    * @param sd
    * @return
    */
	
	private List<FDate> getdatelist(List<FDate> sd,FDate d){		


		List<FDate> fd=new ArrayList<>();
		boolean flag=true;
		for (FDate fDate : sd) {
			
			if(d.before(fDate)&&flag){
				if(!(d.isSameDate(fDate)))
				fd.add(d);
				fd.add(fDate);
				flag=false;
			}else{
				fd.add(fDate);
			}
		}
		if(flag)fd.add(d);
		   
		return fd;
	}
	private String getSrvStr(String code) {

		String str = null;

		String s = "";
		List<UdidocDO> udis = map.get(code);
		for (UdidocDO udi : udis) {
			s += udi.getCode() + ",";
		}

		str = s.substring(0, s.length() - 2);

		return str;
	}

	private void setUdidocs() throws BizException {
		map.clear();

		String filter = getsrvfilter();
		UdidocDO[] udis = service.find(filter, "", FBoolean.TRUE);

		for (UdidocDO udidocDO : udis) {
			String udicode = udidocDO.getCode();
			if (udicode.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
				if (!map.containsKey("obs")) {
					List<UdidocDO> udilist = new ArrayList<UdidocDO>();
					udilist.add(udidocDO);
					map.put("obs", udilist);

				} else {
					List<UdidocDO> udilist = map.get("obs");
					udilist.add(udidocDO);
				}
			}

			if ((udicode.startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG) || udicode.startsWith(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG)) && !udicode.equals(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY)
					&& !udicode.equals(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_PSY)) {
				if (!map.containsKey("drug")) {
					List<UdidocDO> udilist = new ArrayList<UdidocDO>();
					udilist.add(udidocDO);
					map.put("drug", udilist);

				} else {
					List<UdidocDO> udilist = map.get("drug");
					udilist.add(udidocDO);
				}
			}

			if (udicode.startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
				if (!map.containsKey("lab")) {
					List<UdidocDO> udilist = new ArrayList<UdidocDO>();
					udilist.add(udidocDO);
					map.put("lab", udilist);

				} else {
					List<UdidocDO> udilist = map.get("lab");
					udilist.add(udidocDO);
				}
			}
		}

	}

	private String getsrvfilter() {
		String aliname = UdidocDODesc.TABLE_ALIAS_NAME;
		return aliname + ".id_udidoclist ='" + IBdSrvDictCodeTypeConst.ID_SRVTP + "' and ((" + aliname + ".code like '" + IBdSrvDictCodeConst.SD_SRVTP_RIS + "%') or (" + aliname + ".code like '"
				+ IBdSrvDictCodeConst.SD_SRVTP_LIS + "%') or ((" + aliname + ".code like '" + IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG + "%' or " + aliname + ".code like '"
				+ IBdSrvDictCodeConst.SD_SRVTP_CYDRUG + "%') and (" + aliname + ".code!='" + IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY + "' and " + aliname + ".code!='"
				+ IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_PSY + "')))  ";
	}

}
