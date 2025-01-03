package iih.ci.ord.content.d;

import java.util.ArrayList;

import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;

public class CiOrLeaveHosContentFactory extends BaseCiOrContentFactory implements CiOrContentObjFactory {

	@Override
	public CiOrContentDO create(CiEmsDTO ems) {
			// TODO Auto-generated method stub
			if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0){
				return getNullContent(ems);
			}
			CiOrContentDO contentdo=new CiOrContentDO();
			String sd_srvtp = ((CiEmsSrvDTO)ems.getEmssrvs().get(0)).getSd_srvtp();
			if(sd_srvtp != null && sd_srvtp !=""){
				contentdo.setTypeId(sd_srvtp);
			}else{
				contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
			}
			contentdo.setTitle(getTitle(ems));
			contentdo.setItemInfos(getItemInfos(ems));
			contentdo.setTailInfo(getTailInfos(ems));
			return contentdo;
		}
	
		/**
		 * 获得标题数据
		 * @param ems
		 * @return
		 */
		private String getTitle(CiEmsDTO ems){
			return ems.getName();
		}
		
		/**
		 * 获得表体数据
		 * @param ems
		 * @return
		 */
		private ArrayList<ArrayList<String>>  getItemInfos(CiEmsDTO ems){
			if(ems == null || ems.getEmssrvs() == null) return null;
			ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
			ArrayList<String> arrList = new ArrayList<String>();
			FArrayList emssrvs = ems.getEmssrvs();
			for(int i=0;i <emssrvs.size();i++){
				CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
				if(item.getStatus() == DOStatus.DELETED)continue;
				FMap  map = (FMap)ems.getOrapplysheet();
				OrdApOutDO trando = (OrdApOutDO)map.get(EmsType.OUTHOSP.toString());
				arrList.add("拟于"+trando.getDt_timeout() +""+ ems.getName());
			}
			list.add(arrList);
			return list;
		}
		
		/**
		 * 获得表尾数据
		 * @param ems
		 * @return
		 */
		private ArrayList<String>  getTailInfos(CiEmsDTO ems){
			ArrayList<String> list = new ArrayList<String>();
			list.add(ICiOrContentConst.ChangeToEscapeCharacter(ems.getName_routedes()));
			return list;
		}
	}
