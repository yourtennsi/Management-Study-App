package model;

public class StudentscorecalcLogic {
		public void execute (Studentscore studentscore) {
			int artscore=studentscore.getArt()!=null ?studentscore.getArt():0;
			int musicscore=studentscore.getMusic()!=null?studentscore.getMusic():0;
			int healthscore=studentscore.getHealth()!=null?studentscore.getHealth():0;
			int industrialartscore=studentscore.getIndustrialart()!=null?studentscore.getIndustrialart():0;
			int homeeconomicsscore=studentscore.getHomeeconomics()!=null?studentscore.getHomeeconomics():0;
		int infoscore=studentscore.getInfo()!=null? studentscore.getInfo():0;
//			合計値を処理

	int sumscore=studentscore.getJapanese()+studentscore.getEnglish()+studentscore.getMath()+
studentscore.getScience()+studentscore.getSocialstudeies()+artscore+musicscore+healthscore+industrialartscore+homeeconomicsscore+infoscore;
//	5教科得点
	int fivesumscore=studentscore.getJapanese()+studentscore.getEnglish()+studentscore.getMath()+
			studentscore.getScience()+studentscore.getSocialstudeies();

//	5教科平均値を処理　場合によって、副教科も含めた平均点の算出
	double avr=fivesumscore/5.0;

//	ランク評価処理（目安）
	String rank="";

	if(avr>=80) {rank="A";
	}
	else if(avr>=70) {rank="B";}

	else if(avr>=60) {rank="C";}

	else if(avr>=45) {rank="D";}

	else {rank="E";}

//	合計値、平均値 ランク評価を上書き
	studentscore.setSumscore(sumscore);
	studentscore.setAvr(avr);
	studentscore.setRank(rank);
	}
}
