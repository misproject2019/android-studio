package com.example.bestieat;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class user_register extends AppCompatActivity implements View.OnClickListener{
    private Button register;
    private Button signin;
    private Button birth;
    private Button gender;
    String single[] = {"男性", "女性", "其他"};
    private String singleChoice;
    private EditText name,email,pass,phone,again;
    private CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_register);

        register=(Button)findViewById(R.id.register);
        register.setOnClickListener(this);
        signin=(Button)findViewById(R.id.signin);
        signin.setOnClickListener(this);
        birth =(Button)findViewById(R.id.birth);
        gender =(Button)findViewById(R.id.gender);

        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        pass = (EditText)findViewById(R.id.pass);
        again = (EditText)findViewById(R.id.pass_again);
        phone = (EditText)findViewById(R.id.phone);

        checkbox = (CheckBox) findViewById(R.id.checkbox);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.register:
                if ("".equals(name.getText().toString().trim()) || "".equals(email.getText().toString().trim()) || "".equals(pass.getText().toString().trim()) || "".equals(again.getText().toString().trim()) || "".equals(gender.getText().toString().trim()) || "".equals(birth.getText().toString().trim()) || "".equals(phone.getText().toString().trim())) {
                    Toast toast = Toast.makeText(user_register.this, "欄位不能是空白!!", Toast.LENGTH_LONG);
                    toast.show();
                    break;
                }
                else if (!pass.getText().toString().trim().equals(again.getText().toString().trim())) {
                    Toast toast = Toast.makeText(user_register.this, "密碼不符合", Toast.LENGTH_LONG);
                    toast.show();
                    break;
                }
                else if (checkbox.isChecked()) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference user = database.getReference("users");
                    user.child(name.getText().toString().trim()).child("name").setValue(name.getText().toString().trim());
                    user.child(name.getText().toString().trim()).child("email").setValue(email.getText().toString().trim());
                    user.child(name.getText().toString().trim()).child("pass").setValue(pass.getText().toString().trim());
                    user.child(name.getText().toString().trim()).child("gender").setValue(gender.getText().toString().trim());
                    user.child(name.getText().toString().trim()).child("birth").setValue(birth.getText().toString().trim());
                    user.child(name.getText().toString().trim()).child("phone").setValue(phone.getText().toString().trim());
                    user.child(name.getText().toString().trim()).child("point").setValue("100");
                    startActivity(new Intent(this, npc.class));
                    break;
                }
                else {
                    Toast toast = Toast.makeText(user_register.this, "請詳細閱讀隱私權政策唷！", Toast.LENGTH_LONG);
                    toast.show();
                    break;
                }
            case R.id.signin:
                startActivity(new Intent(this, sign.class));
                break;
        }
    }

    public void datePickerDialog(View view) {
        Dialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                birth.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
            }
        }, 2019, 10, 2);
        dialog.show();//显示对话框
    }

    public void singleChoiceItems(View view) {
        Dialog dialog = new AlertDialog.Builder(this)
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        singleChoice = single[0];//默认选择第一项
                        dialog.dismiss();
                    }
                })
                //设置单选框监听
                .setSingleChoiceItems(single, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        singleChoice = single[which];//根据which决定选择了哪一个子项
                        gender.setText(singleChoice);
                    }
                }).create();
        dialog.show();
    }

    public void policyClicked(View view) {
        Dialog dialog = new AlertDialog.Builder(this)
                .setTitle("隱私權政策")
                .setMessage("BESTIEAT應用程式(以下簡稱「BESTIEAT」)非常重視您的隱私權。為確保網際網路使用者在使用BESTIEAT時的隱私權，故訂定此隱私權說明，藉以協助您瞭解BESTIEAT如何保護您所提供的個人資訊，以及如何蒐集、處理及運用您所提供的各項資訊。請您詳讀下列內容，以促進您安心使用BESTIEAT的各項貼心服務。同時，BESTIEAT所蒐集到的個人資料，除其他法律另有規定者外，謹遵守「個人資料保護法」之規範辦理。\n" +
                        "我們已採取符合法規要求的實體、電子和程序防護措施，以保護您個人資料的安全。當用戶透過BESTIEAT提供個人資訊，所有資訊將被安置在一個安全的內部數據庫。為了防止未經授權的訪問，丟失或誤用，保持數據的準確性，並確保適當使用信息，我們已在物理，電子和管理程序等各方面，致力維護和保護個人信息。BESTIEAT採用行業標準技術，如防火牆，以努力保護您的個人資訊的保密性。\n" +
                        "\n" +
                        "一、隱私權政策宣示適用範圍\n" +
                        "   以下的隱私權政策，適用於您在BESTIEAT活動時，所涉及的個人資料蒐集、運用與保護，但不適用於其他非BESTIEAT所有或控制的公司軟體或網站，或非BESTIEAT僱用或管理之人。凡經由BESTIEAT連結之其他軟體或網站，均有其專屬之隱私權政策，BESTIEAT不負任何連帶責任。當您連結這些軟體或網站時，關於個人資料的保護，適用各該軟體或網站的隱私權政策。\n" +
                        "\n" +
                        "二、總論\n" +
                        "   (1)隱私權保護政策內容包括BESTIEAT如何處理由用戶使用BESTIEAT服務時所收集到的身份識別資料，也包括BESTIEAT如何處理在商業伙伴與BESTIEAT合作時分享的任何身份識別資料。\n" +
                        "   (2)個人資料是指可辨識、或可用於辨識您的身份，並被提交至BESTIEAT和(或)由BESTIEAT收集的資料。例如：個人姓名、郵遞地址、電子郵件位址及電話號碼等。本政策不適用於非BESTIEAT所有或控制的公司，也不適用於非 BESTIEAT 僱用或管理之人。\n" +
                        "\n" +
                        "三、個人資料蒐集與使用\n" +
                        "(1) 資料蒐集\n" +
                        "   I.在您註冊BESTIEAT帳號、使用BESTIEAT產品或服務、瀏覽BESTIEAT網頁或某些合作夥伴的網頁，以及參加宣傳活動或贈獎遊戲時，BESTIEAT會蒐集您的個人資料。BESTIEAT也可能從商業夥伴或其他公司處取得您的個人資料，並將這些資料與BESTIEAT所擁有的您的個人資料相結合。\n" +
                        "   II.蒐集方式\n" +
                        "       A. 當使用者註冊時，我們會蒐集您的姓名、地址、電話、電子郵遞地址、網路平台申請之帳號(如facebook、Google等)、申辦查詢服務之紀錄、年齡、性別、出生年月日等資料。\n" +
                        "       B. BESTIEAT也自動接收並記錄您電腦、瀏覽器、行動應用裝置上的資料。電腦和瀏覽器的資料包括IP位址、BESTIEAT cookie(C132)中的資料、軟體和硬體屬性、您瀏覽的網頁紀錄。行動應用裝置上的資料包含電信商資料、連線網際網路的方式、軟體和硬體屬性、目前位置之地理資訊。\n" +
                        "(2) BESTIEAT將個人資料用作以下用途：\n" +
                        "   I.客製化廣告及您看到的網頁內容、滿足您對產品和服務的要求、改進我們的服務、聯絡您、進行研究，以及提供內部及外部客戶匿名報告。\n" +
                        "   II. BESTIEAT蒐集您個人資料之目的係為確認身分及建立您的會員資料檔案，並提供您所申請的服務。法定特定目的為：行銷、會員管理、非公務機關依法定義務所進行個人資料之蒐集處理及利用、契約、類似契約或其他法律關係事務、消費者、客戶管理與服務、消費者保護、資(通)訊服務、資(通)訊與資料庫管理、調查、統計與研究分析、其他經營合於營業登記項目或組織章程所定之業務。除法令另有規定外，BESTIEAT及相關服務所取得的個人資料，在您註冊成為會員的期間內，於BESTIEAT業務營運所及的中華民國境內和未受主管機關禁止國際傳輸的境外地區，僅在為達上述蒐集個資目的的必要範圍內，以下列之方式利用：\n" +
                        "       A. 以會員身份使用BESTIEAT提供之各項服務時，於頁面中自動顯示會員資訊。\n" +
                        "       B. 宣傳廣告或行銷：提供您各種會員條款、公告等資訊，透過電子郵件、電話、寄發DM、簡訊、EDM等方式提供與「BESTIEAT」服務有關之資訊及合作廠商最新合作活動通知。將會員所瀏覽之內容或廣告，依客戶之個人屬性或購買紀錄、BESTIEAT之瀏覽紀錄等項目，進行個人化作業、會員使用服務之分析、新服務之開發或既有服務之改善等。針對民調、活動、留言版等之意見，或其他服務關連事項，與會員進行聯繫。如您欲拒絕宣傳廣告或行銷通知，您可利用電子郵件，向BESTIEAT取消。\n" +
                        "       C. 回覆客戶之詢問：針對您透過線上回報、電子郵件、郵件、傳真、簡訊、電話或其他任何直接間接連絡方式向「BESTIEAT」所提出之詢問進行回覆。\n" +
                        "       D. 其他業務附隨之事項：附隨於上述利用方式而為BESTIEAT提供服務所必要之使用。\n" +
                        "       E. 其他：提供個別服務時，亦可能於上述利用之方式以外，利用個人資料。此時將在該個別服務之網頁載明其要旨。\n" +
                        "   III.資料分享與揭露\n" +
                        "       A. 本網站絕不會任意出售、交換、或出租任何您的個人資料給其他團體、個人或私人企業。但有下列情形者除外：\n" +
                        "           (i) 配合司法單位合法的調查。\n" +
                        "           (ii) 配合相關職權機關依職務需要之調查或使用。\n" +
                        "           (iii) 基於善意相信揭露為法律需要，或為維護和改進網站服務而用於管理。\n" +
                        "       B. 除非是為了向您提供您所要求的產品或服務、獲得您的授權，或有以下情形，否則BESTIEAT不會向任何其他人士或非關係企業出借或出售您的個人資料，或與之分享：\n" +
                        "           (i) 我們向已簽署保密協議書之代表BESTIEAT執行業務或與我們共事的值得信賴的合作夥伴提供這些資料。這些公司可能會將您的個人資料用於協助BESTIEAT就我們和行銷夥伴所提供產品及服務的事宜，與您進行溝通，但這些公司無權利分享這些資料。\n" +
                        "           (ii) BESTIEAT會根據您的個人資料向您展示精準式行銷廣告。廣告主(包括廣告遞送公司)可能假定那些瀏覽、點閱精準式行銷廣告或與廣告互動的人士符合精準式行銷標準，例如特定地理區域內特定年齡層的男性或女性。在您瀏覽精準式行銷廣告或與廣告發生互動時，BESTIEAT不會向廣告主提供您的任何個人資料。然而，一旦瀏覽廣告或與廣告發生互動，即表示您同意廣告主可能會假定您符合展示型廣告所使用的精準式行銷標準。\n" +
                        "\n" +
                        "四、Cookie之使用個人資料蒐集與使用\n" +
                        "   (1) BESTIEAT會存取網站內外與產品及服務有關的cookie。我們使用cookies來追蹤瀏覽BESTIEAT的用戶(如瀏覽的網頁、瀏覽BESTIEAT的時間、以及瀏覽BESTIEAT前與之後瀏覽的網站等)進行統計和市場調查的目的，這是在被允許而且匿名狀態下收集的資訊。我們使用cookies來收集有關BESTIEAT用戶的瀏覽器活動，用來改善BESTIEAT，以提供更好的客戶服務這些資訊也將幫助我們設計和安排我們的網頁在一個最方便的方式，不斷地改進本網站內容，以滿足廣大客戶的需求。而您仍可以透過修改瀏覽器的喜好設定，選擇或拒絕所有的cookies，但是，將可能在您瀏覽本網站時，會影響某些功能或無法使用。\n" +
                        "   (2) BESTIEAT允許在某些BESTIEAT網頁上刊登廣告的其他公司在您的電腦上設定並存取 cookie。但其他公司將根據其自訂的隱私權政策使用其cookie，並非依據本政策。\n" +
                        "   (3) 廣告主或其他公司不能存取BESTIEAT的cookie。\n" +
                        "\n" +
                        "五、隱私權政策修訂及當事人權利行使：\n" +
                        "   (1) 您可隨時修改個人BESTIEAT帳號資料，我們保有權利向您傳送BESTIEAT服務相關的特定訊息、(如服務公告、管理訊息)，這些訊息被視為您BESTIEAT帳號的一部分，您無法選擇退出接收。\n" +
                        "   (2) 隨政府法令或市場環境改變，BESTIEAT將不定時修訂隱私權政策。當我們在個人資料的處理上有重大變更時，會將通知傳送到您在BESTIEAT帳號中指定的主要電子郵件地址，或在行動應用裝置app中以張貼告示或推播訊息的方式進行通知。若您對BESTIEAT個人資料保護事項或隱私權政策有疑問或您依照個人資料保護法第三條欲行使以下權利時，你可使用電子郵件方式接洽BESTIEAT。\n" +
                        "   (3) 您可依照個人資料保護法第三條行使以下權利：\n" +
                        "       I. 查詢或請求閱覽。\n" +
                        "       II. 請求製給複製本。\n" +
                        "       III. 請求補充或更正。\n" +
                        "       IV. 請求停止蒐集、處理或利用\n" +
                        "       V. 請求刪除。\n" +
                        "\n" +
                        "六、儲存的個人資訊和安全：\n" +
                        "   (1) 只有員工在需要查閱用戶個人資訊來履行自己的職責時，被授予查閱個人身份資訊。而未經授權的查閱或使用這些個人資訊的員工，將構成紀律處分的理由，我們的資訊管理系統的配置亦以這樣的方式，以阻止或禁止員工查閱用戶個人資訊。\n" +
                        "   (2) 我們值得信賴的供應商和商業夥伴負責處理或處理一些資訊，將可能查閱到用戶個人資訊，但這些供應商和商業夥伴無權使用這些個人資訊，且不得保存，而為了保持機密性，我們將不會提供必要之外的資訊。\n" +
                        "   (3) 為保障您的隱私及安全，您的帳號資料會用密碼保護，雖然我們致力保障用戶個人資訊，但若您自願在線上透露各種個人資料，該資訊可能會被其他人收集或使用。若為我們無法控制的因素導致洩露個人資訊，我們不承擔任何保證或申述以維護或保密的任何個人信息收集的用戶、潛在用戶或訪客。\n" +
                        "\n" +
                        "七、隱私權政策之適用地區\n" +
                        "   BESTIEAT主要在台灣進行相關業務之推展，故BESTIEAT之經營管理政策，係根據中華民國之法令。如果您從台灣(台、澎、金、馬)以外地區使用我們的服務，即表示您同意個人資訊處理的方式，將根據中華民國之法令規範。此外，台灣在個人資料相關法律規範可能不同於別國之法律，因此可能無法為您提供與您所在國家相同的權利及法令保護。\n" +
                        "\n" +
                        "八、問題和建議\n" +
                        "   如果您有任何問題或建議，請透過客服信箱與我們聯繫。")
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create();
        dialog.show();
    }
}
