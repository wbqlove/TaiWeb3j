/*
 * Copyright 2019 Web3 Labs LTD.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.taiweb3j.response.transaction;

import org.web3j.crypto.Sign;
import org.web3j.crypto.SignatureDataOperations;

import java.math.BigInteger;

public class SignedTaiRawTransaction extends TaiRawTransaction implements SignatureDataOperations {

    private final Sign.SignatureData signatureData;

    public SignedTaiRawTransaction(
            BigInteger nonce,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            BigInteger value,
            String data,
            BigInteger fee,
            String payment,
            Sign.SignatureData signatureData) {
        super(nonce, gasPrice, gasLimit, to, value, data,fee,payment);
        this.signatureData = signatureData;
    }

    public Sign.SignatureData getSignatureData() {
        return signatureData;
    }

    @Override
    public byte[] getEncodedTransaction(Long chainId) {
        if (null == chainId) {
            return TaiTransactionEncoder.encode(this);
        } else {
            return TaiTransactionEncoder.encode(this, chainId);
        }
    }
}
