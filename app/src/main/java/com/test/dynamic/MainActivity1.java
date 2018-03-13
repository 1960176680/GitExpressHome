package com.test.dynamic;

import android.app.Activity;

public class MainActivity1 extends Activity {
//    @SuppressLint("NewApi")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
////        http://10.38.1.73:8080/sjyz/dynamic.jar
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main1);
//        final ProgressDialog progressBar=new ProgressDialog(MainActivity1.this);
////        progressBar.setCanceledOnTouchOutside(false);
//        if (progressBar.isShowing()){
//            progressBar.dismiss();
//        }
//        progressBar.show();
//
//
//       new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    URL url = new URL("http://10.38.1.73:8080/sjyz/dynamic.jar");
//                    HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
//                    InputStream is =httpURLConnection.getInputStream();
//                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                    File f=new File(Environment.getExternalStorageDirectory()+File.separator+"dynamic.jar");
//                    if (f.exists()){
//                        f.delete();
//                    }
////
//                    FileOutputStream outputStream=new FileOutputStream(Environment.getExternalStorageDirectory()+File.separator+"dynamic.jar");
//                    byte[] buffer = new byte[1024];
//                    int len = 0;
//                    while(-1 != (len = is.read(buffer))){
////                baos.write(buffer,0,len);
////                baos.flush();
//                        outputStream.write(buffer,0,len);
////                        outputStream.flush();
//                    }
//                    outputStream.close();
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            progressBar.dismiss();
//                        }
//                    });
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
//
//
//
//
//
//        Button button=findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String libPath = getExternalStorageDirectory()+ File.separator + "dynamic.jar"; // 要动态加载的jar
//                File file=new File(libPath);
//                boolean b = file.exists();
//                File dexDir = getDir("dex", MODE_PRIVATE); // 优化后dex的路径
//                /**
//                 * 进行动态加载，利用java的反射调用com.test.dynamic.MyClass的方法
//                 */
//                DexClassLoader classLoader = new DexClassLoader(libPath, dexDir.getAbsolutePath(), null, getClassLoader());
//                try {
//                    Class<Object> cls = (Class<Object>) classLoader.loadClass("com.test.dynamic.MyClass");
//                    Object object = cls.newInstance();
//                    Method method = cls.getMethod("doSomething");
//                    String s = (String) method.invoke(object);
//
//
//                    Intent intent=new Intent(MainActivity1.this,SecondActivity.class);
//                    intent.putExtra("result",s);
//                    startActivity(intent);
////                    showTipDialog(s);
//                    Toast.makeText(MainActivity1.this, s, Toast.LENGTH_LONG).show();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//
//    }
//    public void showTipDialog(String s){
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity1.this);
//        builder.setTitle("注意:重要提示");
//        builder.setMessage(s);
//        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        builder.show();
//
//    }
}
