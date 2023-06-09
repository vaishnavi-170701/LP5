package ConcatApp;


/**
* ConcatApp/ConcatHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Concat.idl
* Sunday, May 28, 2023 10:39:02 AM EDT
*/

abstract public class ConcatHelper
{
  private static String  _id = "IDL:ConcatApp/Concat:1.0";

  public static void insert (org.omg.CORBA.Any a, ConcatApp.Concat that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ConcatApp.Concat extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (ConcatApp.ConcatHelper.id (), "Concat");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ConcatApp.Concat read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ConcatStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ConcatApp.Concat value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static ConcatApp.Concat narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ConcatApp.Concat)
      return (ConcatApp.Concat)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ConcatApp._ConcatStub stub = new ConcatApp._ConcatStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static ConcatApp.Concat unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ConcatApp.Concat)
      return (ConcatApp.Concat)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ConcatApp._ConcatStub stub = new ConcatApp._ConcatStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
