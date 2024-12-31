package iih.sc.apt.aptmthava;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

/**
 * 拆分医嘱内容
 * 
 * @author ccj
 *
 */
public class SplitContentOrUtil {
	
	/**拆分医嘱内容 
	 * @param content_or 医嘱内容
	 * @return 
	 * @return
	 * @throws BizException
	 */
	public static String exec(String content_or) throws BizException {
		if(StringUtils.isBlank(content_or)) return null;
		DoctorOrderItem doctorOrderItem = new DoctorOrderItem();
		List<DoctorOrderItem> DoctorOrderItemList = new ArrayList<DoctorOrderItem>();
		String[] TypeArray = content_or.split("\\|");
		if (TypeArray.length >= 3) {
			for (int i = 0; i < TypeArray.length; i++) {
				doctorOrderItem = new DoctorOrderItem();
				doctorOrderItem.Text = TypeArray[i];
				DoctorOrderItemList.add(doctorOrderItem);
			}
			String[] NameArray = TypeArray[2].split("^");
			for (int i = 0; i < NameArray.length; i++) {
				doctorOrderItem = new DoctorOrderItem();
				doctorOrderItem.Text = NameArray[i];
				if (DoctorOrderItemList.get(2).SubDoctorOrderItem == null) {
					DoctorOrderItemList.get(2).SubDoctorOrderItem = new ArrayList<DoctorOrderItem>();
				}
				DoctorOrderItemList.get(2).SubDoctorOrderItem.add(doctorOrderItem);
				String[] NoteAyyay = NameArray[i].split("&");
				for (int j = 0; j < NoteAyyay.length; j++) {
					doctorOrderItem = new DoctorOrderItem();
					doctorOrderItem.Text = NoteAyyay[j];
					if (DoctorOrderItemList.get(2).SubDoctorOrderItem.get(i).SubDoctorOrderItem == null) {
						DoctorOrderItemList.get(2).SubDoctorOrderItem.get(i).SubDoctorOrderItem = new ArrayList<DoctorOrderItem>();
					}
					DoctorOrderItemList.get(2).SubDoctorOrderItem.get(i).SubDoctorOrderItem.add(doctorOrderItem);
				}
			}
			String[] UsageArray = TypeArray[2].split("&");
			for (int i = 0; i < UsageArray.length; i++) {
				doctorOrderItem = new DoctorOrderItem();
				doctorOrderItem.Text = UsageArray[i];
				if (DoctorOrderItemList.get(2).SubDoctorOrderItem == null) {
					DoctorOrderItemList.get(2).SubDoctorOrderItem = new ArrayList<DoctorOrderItem>();
				}
				DoctorOrderItemList.get(2).SubDoctorOrderItem.add(doctorOrderItem);
			}
		}else {
            doctorOrderItem = new DoctorOrderItem();
            doctorOrderItem.Text = content_or;
        }
		return doctorOrderItem.getText();
	}

}

class DoctorOrderItem
{
    public String Text;
    public List<DoctorOrderItem> SubDoctorOrderItem;
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
    
}

