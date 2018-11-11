package sg.casa.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import PageObjectModel.UploadFilePageObjModel;
import net.thucydides.core.annotations.findby.By;

public class UploadFile extends SG_CASA_UI_Elements {
	WebDriver driver;

	public UploadFile(WebDriver driver) {
		this.driver = driver;
	}

	public void performfileupload(Sheet sheet, String primarykey) throws Exception {
		filehandlingfeatures loadfiles = new filehandlingfeatures();
		HashMap<String, Integer> fileupload = loadfiles.getexcelcolnumber(sheet, 1);
		PageFactory.initElements(driver, this);
		CommonMethords action= new CommonMethords();
		for (int rw = 1; rw <= sheet.getLastRowNum(); rw++) {
			if (sheet.getRow(rw).getCell(fileupload.get("Primary_Key")).getStringCellValue().trim().equals(primarykey)) {
				String File_typeToUpload = sheet.getRow(rw).getCell(fileupload.get("File_typeToUpload")).getStringCellValue().trim();

				String Check_Singlefile_upload_PA = sheet.getRow(rw).getCell(fileupload.get("Check_Singlefile_upload_PA")).getStringCellValue().trim();
				String Singnature_Upload_PA = sheet.getRow(rw).getCell(fileupload.get("Singnature_Upload_PA")).getStringCellValue().trim();

				String Check_Singlefile_upload_JA = sheet.getRow(rw).getCell(fileupload.get("Check_Singlefile_upload_JA")).getStringCellValue().trim();
				String Singnature_Upload_JA = sheet.getRow(rw).getCell(fileupload.get("Singnature_Upload_JA")).getStringCellValue().trim();

				String Check_Singlefile_upload_SA = sheet.getRow(rw).getCell(fileupload.get("Check_Singlefile_upload_SA")).getStringCellValue().trim();
				String Singnature_Upload_SA = sheet.getRow(rw).getCell(fileupload.get("Singnature_Upload_SA")).getStringCellValue().trim();

				String Supporting_Documents_PA = sheet.getRow(rw).getCell(fileupload.get("Supporting_Documents_PA")).getStringCellValue().trim();
				String Supporting_Documents_JA = sheet.getRow(rw).getCell(fileupload.get("Supporting_Documents_JA")).getStringCellValue().trim();
				String Supporting_Documents_SA = sheet.getRow(rw).getCell(fileupload.get("Supporting_Documents_SA")).getStringCellValue().trim();

				String Check_CPF_statement = sheet.getRow(rw).getCell(fileupload.get("Check_CPF_statement")).getStringCellValue().trim();

				String absolutefilepath = filehandlingfeatures.fileuploadpath + File_typeToUpload + "/";
				String expectedfiletoSaveAs = absolutefilepath + File_typeToUpload + filehandlingfeatures.validfile;

				if (Check_CPF_statement.equals("check")) {
					CommonMethords.selectcheckbox(CPFStatementchk, Check_CPF_statement);
				}

				if (SG_CASA_UI_Decleration.isPrincApp.size() > 0 && CommonMethords.findelementsvisible(SG_CASA_UI_Decleration.isPrincApp)) {
					if (Singnature_Upload_PA.toUpperCase().equals("SIGN HERE")) {
						PrincipalApplicantSignHerechk.click();
					} else if (Singnature_Upload_PA.toUpperCase().equals("UPLOAD SIGNATURE")) {
						PrincipalApplicantUploadSignchk.click();
						loadfiles.uploadfile(driver, PrincipalApplicantSignfileupload, action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
					}
				}

				if (SG_CASA_UI_Decleration.isJointApp.size() > 0 && CommonMethords.findelementsvisible(SG_CASA_UI_Decleration.isJointApp)) {
					if (Singnature_Upload_JA.toUpperCase().equals("SIGN HERE")) {
						JointApplicantSignHerechk.click();
					} else if (Singnature_Upload_JA.toUpperCase().equals("UPLOAD SIGNATURE")) {
						JointApplicantUploadSignchk.click();
						loadfiles.uploadfile(driver, JointApplicantSignfileupload, action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
					}
				}

				if (SG_CASA_UI_Decleration.isSuppApp.size() > 0 && CommonMethords.findelementsvisible(SG_CASA_UI_Decleration.isSuppApp)) {
					if (Singnature_Upload_SA.toUpperCase().equals("SIGN HERE")) {
						SupplementaryApplicantSignHerechk.click();
					} else if (Singnature_Upload_SA.toUpperCase().equals("UPLOAD SIGNATURE")) {
						SupplementaryApplicantUploadSignchk.click();
						loadfiles.uploadfile(driver, SupplementaryApplicantSignfileupload, action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
					}
				}

				List<WebElement> SignHere = driver.findElements(By.xpath(Singnature));
				System.out.println(SignHere.size());
				for (WebElement Signing : SignHere) {
					if (Signing.isDisplayed()) {
						loadfiles.Signhere(driver, Signing);
					}
				}

				if (SG_CASA_UI_Decleration.isPrincApp.size() > 0 && CommonMethords.findelementsvisible(SG_CASA_UI_Decleration.isPrincApp)) {
					if (Check_Singlefile_upload_PA.equals("check")) {
						Singlefileupload_PA.click();
						loadfiles.uploadfile(driver, firstfilePrincipalAccount.get(0), action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
					} else if (Check_Singlefile_upload_PA.equals("uncheck")) {
						try {
							loadfiles.uploadfile(driver, firstfilePrincipalAccount.get(0), action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
							loadfiles.uploadfile(driver, secondfilePrincipalAccount.get(0), action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
						} catch (Exception e) {
						}
					} else {
						if (firstfilePrincipalAccount.size() > 0)
							loadfiles.uploadfile(driver, firstfilePrincipalAccount.get(0), action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
					}
					if (Supporting_Documents_PA.equals("required")) {
						loadfiles.uploadfile(driver, PrinAppSupportingDocuments, action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
					}
				}

				if (SG_CASA_UI_Decleration.isJointApp.size() > 0 && CommonMethords.findelementsvisible(SG_CASA_UI_Decleration.isJointApp)) {
					if (Check_Singlefile_upload_JA.equals("check")) {
						Singlefileupload_JA.click();
						loadfiles.uploadfile(driver, firstfileJointAccount.get(0), action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
					} else if (Check_Singlefile_upload_JA.equals("uncheck")) {
						try {
							loadfiles.uploadfile(driver, firstfileJointAccount.get(0), action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
							loadfiles.uploadfile(driver, secondfileJointAccount.get(0), action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
						} catch (Exception e) {
						}
					} else {
						if (firstfileJointAccount.size() > 0)
							loadfiles.uploadfile(driver, firstfileJointAccount.get(0), action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
					}

					if (Supporting_Documents_JA.equals("required")) {
						loadfiles.uploadfile(driver, JointAppSupportingDocuments, action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
					}
				}

				if (SG_CASA_UI_Decleration.isSuppApp.size() > 0 && CommonMethords.findelementsvisible(SG_CASA_UI_Decleration.isSuppApp)) {
					if (Check_Singlefile_upload_SA.equals("check")) {
						Singlefileupload_SA.click();
						loadfiles.uploadfile(driver, firstfileSupplementaryAccount.get(0), action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
					} else if (Check_Singlefile_upload_SA.equals("uncheck")) {
						try {
							loadfiles.uploadfile(driver, firstfileSupplementaryAccount.get(0), action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
							loadfiles.uploadfile(driver, secondfileSupplementaryAccount.get(0), action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
						} catch (Exception e) {
						}
					} else {
						if (firstfileSupplementaryAccount.size() > 0)
							loadfiles.uploadfile(driver, firstfileSupplementaryAccount.get(0), action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
					}

					if (Supporting_Documents_SA.equals("required")) {
						loadfiles.uploadfile(driver, SupplementaryAppSupportingDocuments, action.SaveAsfilewithuniquename(absolutefilepath,expectedfiletoSaveAs));
					}
				}
			}
		}
	}
}
