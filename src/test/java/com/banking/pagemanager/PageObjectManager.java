package com.banking.pagemanager;

import com.banking.pages.*;

public class PageObjectManager {
    private UserLogin userLogin; 
    private AccountOverview accountOverview;
    private TransferFunds transferFunds;
    private OpenNewAccount openNewAccount;
    private BillPayment billPayment;
    private RequestLoan requestLoan;
    private ContactUs contactUs;
    private Logout logout;


    public UserLogin getUserLogin() {
        return (userLogin == null) ? userLogin = new UserLogin() : userLogin;
    } 
    
    public AccountOverview getaccountOverview() {
        return (accountOverview == null) ? accountOverview = new AccountOverview() : accountOverview;
    } 
    
    public TransferFunds gettransferFunds() {
        return (transferFunds == null) ? transferFunds = new TransferFunds() : transferFunds;
    } 
    
    public OpenNewAccount getopenNewAccount() {
        return (openNewAccount == null) ? openNewAccount = new OpenNewAccount() : openNewAccount;
    }

    public BillPayment getbillPayment() {
        return (billPayment == null) ? billPayment = new BillPayment() : billPayment;
    }
    
    public RequestLoan getrequestLoan() {
        return (requestLoan == null) ? requestLoan = new RequestLoan() : requestLoan;
    }
    
    public ContactUs getcontactUs() {
        return (contactUs == null) ? contactUs = new ContactUs() : contactUs;
    }
   
    public Logout getlogout() {
        return (logout == null) ? logout = new Logout() : logout;
    }

}