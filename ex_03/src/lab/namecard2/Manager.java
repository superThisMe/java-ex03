package lab.namecard2;

import lab.namecard2.NameCard ;

public interface Manager {

	public boolean insertNameCard(NameCard namecard);
	public NameCard findNameCard(String name);
	public boolean modifyNameCard();
	public boolean deleteNameCard(String name);
	public void showAll();
	
}
