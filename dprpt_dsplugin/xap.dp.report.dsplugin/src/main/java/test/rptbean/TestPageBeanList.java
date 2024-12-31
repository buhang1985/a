package test.rptbean;

import java.util.ArrayList;
import java.util.Iterator;

public class TestPageBeanList {

	public TestPageBeanList() {
		
	}
	
	public Iterator<Student> getStuIter(String strCnt, String strSubCnt) {
		int cnt = 20, subcnt = 5;
		
		try {
			cnt = Integer.parseInt(strCnt);
			subcnt = Integer.parseInt(strSubCnt);
		}
		catch(Exception ex) {
			cnt = 20;
			subcnt = 5;
		}
		
		return this.getStuIter(cnt, subcnt);
	}
	
	public Iterator<Student> getStuIter(int cnt, int subCnt) {
		ArrayList<Student> stu_list = new ArrayList<Student>();
		this._fillData(stu_list, cnt, subCnt);
		
		return stu_list.iterator();
	}
	/**
	 * 测试数据填充
	 * @param stuList
	 * @param cnt			主表记录数
	 * @param subCnt	子表记录数 (<=0时使用随机数量)
	 */
	private void _fillData(ArrayList<Student> stuList, int cnt, int subCnt) {
		int tmp_subcnt = subCnt;
		
		for(int ix=1; ix<=cnt; ix++) {
			int age = (22 + 3 * (ix/5));
			int mark = (70 + 3 * (ix/5));
			Student stu = new Student(ix, "StuAAA_"+ix, age, mark);
			stu.setDoctorOrder("0101||0.9%氯化钠注射液&250&ml^维生素C针&0.5&g^维生素B针&2&mg|静脉滴注&每日一次&");
			
			// 循环计算子表记录数量
			if(subCnt <= 0) tmp_subcnt = 10 + ix%5;
			
			for(int jx=0; jx<tmp_subcnt; jx++) {
				stu.addSubject("学科_"+jx);
			}
			
			stuList.add(stu);
		}
	}
	
	public ArrayList<MedicalExamProblem> getMedicalExamResult() {
		ArrayList<MedicalExamProblem> res = new ArrayList<MedicalExamProblem>();
		MedicalExamProblem exam = null;
		
		exam = new MedicalExamProblem("X光检查", "两膈下肿物");
		res.add(exam);
		
		exam = new MedicalExamProblem("耳鼻喉检查", "先天性耳前瘘管<br/>急性化脓性鼻窦炎<br/>会厌囊肿");
		res.add(exam);
		
		exam = new MedicalExamProblem("腹部超声波", "肝内胆管结石:B超定期（半至一年）复查，必要时肝胆外科就诊。；低脂饮食，适当锻炼，定期（半至一年）复查B超，必要时消化内科或肝病科就诊。");
		res.add(exam);
		
		exam = new MedicalExamProblem("眼科", "视网膜静脉周围炎<br/>双眼结膜炎<br/>晶状体缺如");
		res.add(exam);
		
		return res;
	}
}
