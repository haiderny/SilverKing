package com.ms.silverking.cloud.dht.client;

import com.ms.silverking.cloud.dht.NamespacePerspectiveOptions;
import com.ms.silverking.cloud.dht.VersionConstraint;


/**
 * <p>A namespace perspective is a typed view of a DHT namespace. 
 * Internally, DHT data is stored as untyped sequences of bytes.
 * A namespace perspective translates data between native 
 * Java objects and untyped byte sequences.
 * Multiple namespace perspectives may exist for any given namespace.</p>
 * 
 * <p>SilverKing does not support the storage of null objects, but
 * does support the storage of zero-length byte arrays.
 * Retrieval operations return null for keys that do not have a 
 * value associated with them, unless an exception is requested
 * for non-existent key-value pairs.</p>
 * 
 * <p>
 * This interface provides functionality common to all namespace perspectives.
 * </p> 
 *
 */
public interface BaseNamespacePerspective<K,V> {
	/**
	 * Get the name of the perspective's namespace.
	 * @return namespace name
	 */
	public String getName();
	/**
	 * Get this perspective's Namespace.
	 * @return the perspective's Namespace
	 */
	public Namespace getNamespace();
	/**
	 * Get the NamespacePerspectiveOptions currently in use by this perspective.
	 * @return the NamespacePerspectiveOptions currently in use by this perspective
	 */
	public NamespacePerspectiveOptions<K,V> getOptions();
    /**
     * Alter the NamespacePerspectiveOptions used to in this perspective.
     * @param nspOptions the new NamespacePerspectiveOptions for this perspective
     */
    public void setOptions(NamespacePerspectiveOptions<K,V> nspOptions);
    /**
     * Set default retrieval VersionConstraints
     * @param vc the new default VersionConstraints
     */
    public void setDefaultRetrievalVersionConstraint(VersionConstraint vc);
    /**
     * Set the default VersionProvider used for storage operations.
     * For use only when NamespaceVersionMode is CLIENT_SPECIFIED.
     * @param versionProvider the new default VersionProvider
     */
    public void setDefaultVersionProvider(VersionProvider versionProvider);
    /**
     * Set the default version used for storage operations.
     * For use only when NamespaceVersionMode is CLIENT_SPECIFIED.
     * @param version the new default version
     */
    public void setDefaultVersion(long version);
	/**
	 * Close this perspective
	 */
	public void close();
}
