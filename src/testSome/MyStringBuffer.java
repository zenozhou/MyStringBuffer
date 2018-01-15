package testSome;

public class MyStringBuffer implements IStringBuffer
{
	int capacity = 16;
	int length = 0;
	char [] value; //changeable reference
	public MyStringBuffer() {
		value = new char[capacity];
	}
	public MyStringBuffer(String str) {
		this();
		if(str == null)	return;
		if(str.length()>capacity) {
			capacity = str.length()	*2;
			value = new char[capacity];
		}
		if(capacity>=value.length) {
			System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
		}
		length = str.length();
	}
//Methods----------------------------------
	@Override
	public String toString() {
		char[] realValue = new char[length];
		System.arraycopy(value, 0, realValue, 0, length);
		return String.valueOf(realValue);
	}
	@Override
	public void append(String str) throws IndexIsNegativeException,IndexIsOutofRangeException
	{
		insert(length,str);
	}
	@Override
	public void append(char c) throws IndexIsNegativeException,IndexIsOutofRangeException
	{
		insert(length,String.valueOf(c));
	}
	@Override
	public void insert(int pos,String str)  throws IndexIsNegativeException,IndexIsOutofRangeException
	{
		if(pos<0) throw new IndexIsNegativeException("heloooooo");
		if(str==null) new IndexIsOutofRangeException();
		if(pos>length) return;
		//enlarge capacity
		while(length+str.length()>capacity) {
			capacity = (int)((length+str.length())*1.5f);
			char[] valuecopy = new char[capacity];
			System.arraycopy(value, 0, valuecopy, 0, length);
			value = valuecopy;
		}
		char[] strChar = str.toCharArray();
		System.arraycopy(value, pos, value, pos+strChar.length, length-pos);
		System.arraycopy(strChar, 0, value, pos, strChar.length);
		
		length = str.length()+length;
	}
	@Override
	public void insert(int pos,char c) throws IndexIsNegativeException,IndexIsOutofRangeException
	{
		insert(pos,String.valueOf(c));
	}
	@Override
	public void delete(int start) 
	{
		delete(start,length);
	}
	@Override
	public void delete(int start,int end) 
	{
		if(start<0||end>length) return;
		if(start>end) return;
		System.arraycopy(value, end, value, start, length-end);
		
		length = length -(end - start);
	}
	@Override
	public void reverse() 
	{
			for(int i=0;i<value.length/2;i++) {
				char temp = value[value.length-1-i];
				value[value.length-1-i] = value[i];
				value[i] = temp;
			}
	}
	@Override
	public int length() 
	{
		return length;
	}
	
//Main----------------------------
	public static void main(String[] args) {
		MyStringBuffer mb = new MyStringBuffer();
		try {
		mb.append("hello this fuck helo");
		mb.insert(-1," OK! ");
		System.out.println(mb);
		mb.append("?");
		System.out.println(mb);
		mb.delete(11,15);
		System.out.println(mb);
		}
		catch(IndexIsNegativeException e) {
			System.out.println(e.getClass().getName() + e.getMessage());
			e.printStackTrace();
		}
		catch(IndexIsOutofRangeException e) {
			e.printStackTrace();
		}
		
    }
}
