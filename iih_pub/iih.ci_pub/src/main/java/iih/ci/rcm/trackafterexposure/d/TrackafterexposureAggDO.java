package iih.ci.rcm.trackafterexposure.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.rcm.trackafterexposure.d.desc.TrackafterexposureAggDODesc;



/**
 * 暴露后追踪记录登记表
 */
public class TrackafterexposureAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public TrackAfterExposureDO getParentDO() {
		return ((TrackAfterExposureDO) super.getParentDO());
	}

	public void setParentDO(TrackAfterExposureDO headDO) {
		setParent(headDO);
	}

	public TrackCheckResAfExpDO[] getTrackCheckResAfExpDO() {
		IBaseDO[] dos = getChildren(TrackCheckResAfExpDO.class);
		if(dos==null) return null;
		TrackCheckResAfExpDO[] result=new TrackCheckResAfExpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(TrackCheckResAfExpDO)dos[i];
		}
		return result;
	}
	
	public void setTrackCheckResAfExpDO(TrackCheckResAfExpDO[] dos) {
		setChildren(TrackCheckResAfExpDO.class, dos);
	}
	public TreatPeMeaAfExpDO[] getTreatPeMeaAfExpDO() {
		IBaseDO[] dos = getChildren(TreatPeMeaAfExpDO.class);
		if(dos==null) return null;
		TreatPeMeaAfExpDO[] result=new TreatPeMeaAfExpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(TreatPeMeaAfExpDO)dos[i];
		}
		return result;
	}
	
	public void setTreatPeMeaAfExpDO(TreatPeMeaAfExpDO[] dos) {
		setChildren(TreatPeMeaAfExpDO.class, dos);
	}
	public LabFollowupResultDO[] getLabFollowupResultDO() {
		IBaseDO[] dos = getChildren(LabFollowupResultDO.class);
		if(dos==null) return null;
		LabFollowupResultDO[] result=new LabFollowupResultDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(LabFollowupResultDO)dos[i];
		}
		return result;
	}
	
	public void setLabFollowupResultDO(LabFollowupResultDO[] dos) {
		setChildren(LabFollowupResultDO.class, dos);
	}
	public BasicLabResultDO[] getBasicLabResultDO() {
		IBaseDO[] dos = getChildren(BasicLabResultDO.class);
		if(dos==null) return null;
		BasicLabResultDO[] result=new BasicLabResultDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BasicLabResultDO)dos[i];
		}
		return result;
	}
	
	public void setBasicLabResultDO(BasicLabResultDO[] dos) {
		setChildren(BasicLabResultDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		TrackafterexposureAggDODesc desc = new TrackafterexposureAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new TrackAfterExposureDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.rcm.trackafterexposure.d.TrackCheckResAfExpDO")) {
             return new TrackCheckResAfExpDO();
         }
	    else if (clzName.equals("iih.ci.rcm.trackafterexposure.d.TreatPeMeaAfExpDO")) {
             return new TreatPeMeaAfExpDO();
         }
	    else if (clzName.equals("iih.ci.rcm.trackafterexposure.d.LabFollowupResultDO")) {
             return new LabFollowupResultDO();
         }
	    else if (clzName.equals("iih.ci.rcm.trackafterexposure.d.BasicLabResultDO")) {
             return new BasicLabResultDO();
         }
         return null;
     }
}