package io.mosip.registration.processor.stages.osivalidator;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mosip.registration.processor.core.packet.dto.OsiData;
import io.mosip.registration.processor.filesystem.ceph.adapter.impl.FilesystemCephAdapterImpl;

@Service
public class OSIValidator {

	@Autowired
	FilesystemCephAdapterImpl adapter;

	public boolean isValidOSI(String registrationId) {
		// To do call packet info to get osi data then call each validation

		return false;
	}

	private boolean isValidOperator(OsiData osiData) throws IOException {

		boolean isOperatorValidatorFingerprint = false;
		String Uin = osiData.getOperatorId();
		String FingerPrint = osiData.getOperatorFingerprintImage();
		InputStream FingerPrintFileName = adapter.getFile(Uin, FingerPrint);

		if (validateUIN(Uin)) {
			isOperatorValidatorFingerprint = adapter.checkFileExistence(Uin, FingerPrint);
			if (!isOperatorValidatorFingerprint)
				return false;
			else {
				byte[] FingerPrintByte = IOUtils.toByteArray(FingerPrintFileName);
				return validateOperatorBiometric(Uin, FingerPrintByte);
			}

		}

		return false;
	}

	private boolean isValidSupervisor(OsiData osiData) {

		return false;
	}

	private boolean isValidIntroducer(OsiData osiData) {

		return false;
	}

	private boolean validateUIN(String input) {
		// todo To call IAM rest API for UNI validation
		return true;

	}

	private boolean validateOperatorBiometric(String input, byte[] hmacFileHashByte) {
		return true;

	}
}
