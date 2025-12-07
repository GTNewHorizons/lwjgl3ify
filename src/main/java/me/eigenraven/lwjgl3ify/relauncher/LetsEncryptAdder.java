package me.eigenraven.lwjgl3ify.relauncher;

import java.io.InputStream;
import java.security.KeyStore;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Updates the ca-certificates roots to fix HTTPS connection problems with e.g. Let's Encrypt and Azure certificates.
 * <br>
 *
 * Taken from: <a href=
 * "https://github.com/Cloudhunter/LetsEncryptCraft/blob/master/src/main/java/uk/co/cloudhunter/letsencryptcraft/LetsEncryptAdder.java">LetsEncryptCraft</a>
 * <br>
 * Original code license:
 *
 * <pre>
 * MIT License
 *
 * Copyright (c) 2018 Cloudhunter
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * </pre>
 */
public class LetsEncryptAdder {

    private static boolean alreadyAdded = false;
    private static final Logger LOGGER = LogManager.getLogger(LetsEncryptAdder.class);

    private static void trustLetsEncryptRoots() throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        try (final InputStream keystoreBytes = Objects
            .requireNonNull(LetsEncryptAdder.class.getResourceAsStream("/assets/lwjgl3ify/ssl/java-cacerts.jks"))) {
            keyStore.load(keystoreBytes, "changeit".toCharArray());
        }

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(keyStore);
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);
        SSLContext.setDefault(sslContext);
    }

    public static void addLetsEncryptCertificates() {
        if (alreadyAdded) {
            return;
        }

        String version = System.getProperty("java.version");
        Pattern p = Pattern.compile("^(\\d+\\.\\d+).*?_(\\d+).*");
        Matcher matcher = p.matcher(version);
        String majorVersion;
        int minorVersion;
        if (matcher.matches()) {
            majorVersion = matcher.group(1);
            minorVersion = Integer.parseInt(matcher.group(2));
        } else {
            majorVersion = "1.7";
            minorVersion = 110;
            LOGGER.info("Regex to parse Java version failed - applying anyway.");
        }

        switch (majorVersion) {
            case "1.7":
                if (minorVersion >= 111) {
                    LOGGER.info("Not running as Java version is at least Java 7u111.");
                    alreadyAdded = true;
                    return;
                }
                break;
            case "1.8":
                if (minorVersion >= 101) {
                    LOGGER.info("Not running as Java version is at least Java 8u101.");
                    alreadyAdded = true;
                    return;
                }
                break;
        }

        try {
            LetsEncryptAdder.trustLetsEncryptRoots();
            LOGGER.info("Added Let's Encrypt certificate to the Java SSL trust store.");
        } catch (Exception e) {
            LOGGER.error(
                "An error occurred whilst adding the Let's Encrypt root certificate. I'm afraid you wont be able to access resources with a Let's Encrypt certificate D:",
                e);
        }

        alreadyAdded = true;
    }
}
