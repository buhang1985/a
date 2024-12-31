package iih.bd.srv.mrpsnpower2.bp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import iih.bd.srv.mrpsnpower.d.MrPsnPowerDO;
import iih.bd.srv.mrpsnpower.i.IMrpsnpowerCudService;
import iih.bd.srv.mrpsnpower.i.IMrpsnpowerRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
* 人员权限明细列表的保存
*/
public class SavePowerDos {
	/**
	* 人员权限列表的过滤查询
	 * @throws BizException 
	*/
	public Boolean savePowerDos(MrPsnPowerDO[] powers,String id_psn) throws BizException {
		IMrpsnpowerCudService psnSer1 = ServiceFinder.find(IMrpsnpowerCudService.class);
		IMrpsnpowerRService psnSer2 = ServiceFinder.find(IMrpsnpowerRService.class);
		MrPsnPowerDO[] powDos=psnSer2.find("Id_psn='" + id_psn + "'", "code_pw asc", FBoolean.FALSE);
		psnSer1.delete(powDos);
		
		List<MrPsnPowerDO> list= new ArrayList<MrPsnPowerDO>();
		for (MrPsnPowerDO power : powers) {
			if(null!=power && null!=power.getCode_pw() && !"".equals(power.getCode_pw())){
				list.add(power);
			}
		}
		list=getList(list);
		psnSer1.insert(list.toArray(new MrPsnPowerDO[list.size()]));
		
		return true;
	}
	
	/**
	 * 相同权限去重
	 * @param list
	 * @return
	 */
	public List<MrPsnPowerDO> getList(List<MrPsnPowerDO> list){
		Set<MrPsnPowerDO> set = new TreeSet<MrPsnPowerDO>(new Comparator<MrPsnPowerDO>() {
            @Override
            public int compare(MrPsnPowerDO o1, MrPsnPowerDO o2) {
                //字符串,则按照asicc码升序排列
                return o1.getCode_pw().compareTo(o2.getCode_pw());
            }
        });
        set.addAll(list);
        return new ArrayList<MrPsnPowerDO>(set);
	}
}
