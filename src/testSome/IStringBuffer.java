package testSome;

public interface IStringBuffer {
	public void append(String str) throws IndexIsNegativeException,IndexIsOutofRangeException; //׷���ַ���
    public void append(char c) throws IndexIsNegativeException,IndexIsOutofRangeException;  //׷���ַ�
    public void insert(int pos,char b) throws IndexIsNegativeException,IndexIsOutofRangeException; //ָ��λ�ò����ַ�
    public void insert(int pos,String b) throws IndexIsNegativeException,IndexIsOutofRangeException; //ָ��λ�ò����ַ���
    public void delete(int start); //�ӿ�ʼλ��ɾ��ʣ�µ�
    public void delete(int start,int end); //�ӿ�ʼλ��ɾ������λ��-1
    public void reverse(); //��ת
    public int length(); //���س���
}
