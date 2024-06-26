/*
 * Files.com API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.1
 * Contact: support@files.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.brick.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.brick.io.swagger.client.model.FormFieldSetEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
/**
 * Create Bundle
 */
@Schema(description = "Create Bundle")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T22:25:43.390877+02:00[Europe/Paris]")
public class BundleEntity {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("password_protected")
  private Boolean passwordProtected = null;

  @JsonProperty("preview_only")
  private Boolean previewOnly = null;

  @JsonProperty("require_registration")
  private Boolean requireRegistration = null;

  @JsonProperty("require_share_recipient")
  private Boolean requireShareRecipient = null;

  @JsonProperty("clickwrap_body")
  private String clickwrapBody = null;

  @JsonProperty("form_field_set")
  private FormFieldSetEntity formFieldSet = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("created_at")
  private DateTime createdAt = null;

  @JsonProperty("expires_at")
  private DateTime expiresAt = null;

  @JsonProperty("max_uses")
  private Integer maxUses = null;

  @JsonProperty("note")
  private String note = null;

  @JsonProperty("user_id")
  private Integer userId = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("clickwrap_id")
  private Integer clickwrapId = null;

  @JsonProperty("inbox_id")
  private Integer inboxId = null;

  @JsonProperty("has_inbox")
  private Boolean hasInbox = null;

  @JsonProperty("paths")
  private List<String> paths = null;

  public BundleEntity code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Bundle code.  This code forms the end part of the Public URL.
   * @return code
  **/
  @Schema(example = "abc123", description = "Bundle code.  This code forms the end part of the Public URL.")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public BundleEntity url(String url) {
    this.url = url;
    return this;
  }

   /**
   * Public URL of Share Link
   * @return url
  **/
  @Schema(example = "https://subdomain.files.com/f/12345678", description = "Public URL of Share Link")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public BundleEntity description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Public description
   * @return description
  **/
  @Schema(example = "The public description of the bundle.", description = "Public description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BundleEntity passwordProtected(Boolean passwordProtected) {
    this.passwordProtected = passwordProtected;
    return this;
  }

   /**
   * Is this bundle password protected?
   * @return passwordProtected
  **/
  @Schema(description = "Is this bundle password protected?")
  public Boolean isPasswordProtected() {
    return passwordProtected;
  }

  public void setPasswordProtected(Boolean passwordProtected) {
    this.passwordProtected = passwordProtected;
  }

  public BundleEntity previewOnly(Boolean previewOnly) {
    this.previewOnly = previewOnly;
    return this;
  }

   /**
   * Restrict users to previewing files only?
   * @return previewOnly
  **/
  @Schema(description = "Restrict users to previewing files only?")
  public Boolean isPreviewOnly() {
    return previewOnly;
  }

  public void setPreviewOnly(Boolean previewOnly) {
    this.previewOnly = previewOnly;
  }

  public BundleEntity requireRegistration(Boolean requireRegistration) {
    this.requireRegistration = requireRegistration;
    return this;
  }

   /**
   * Show a registration page that captures the downloader&#x27;s name and email address?
   * @return requireRegistration
  **/
  @Schema(description = "Show a registration page that captures the downloader's name and email address?")
  public Boolean isRequireRegistration() {
    return requireRegistration;
  }

  public void setRequireRegistration(Boolean requireRegistration) {
    this.requireRegistration = requireRegistration;
  }

  public BundleEntity requireShareRecipient(Boolean requireShareRecipient) {
    this.requireShareRecipient = requireShareRecipient;
    return this;
  }

   /**
   * Only allow access to recipients who have explicitly received the share via an email sent through the Files.com UI?
   * @return requireShareRecipient
  **/
  @Schema(description = "Only allow access to recipients who have explicitly received the share via an email sent through the Files.com UI?")
  public Boolean isRequireShareRecipient() {
    return requireShareRecipient;
  }

  public void setRequireShareRecipient(Boolean requireShareRecipient) {
    this.requireShareRecipient = requireShareRecipient;
  }

  public BundleEntity clickwrapBody(String clickwrapBody) {
    this.clickwrapBody = clickwrapBody;
    return this;
  }

   /**
   * Legal text that must be agreed to prior to accessing Bundle.
   * @return clickwrapBody
  **/
  @Schema(example = "[Legal text]", description = "Legal text that must be agreed to prior to accessing Bundle.")
  public String getClickwrapBody() {
    return clickwrapBody;
  }

  public void setClickwrapBody(String clickwrapBody) {
    this.clickwrapBody = clickwrapBody;
  }

  public BundleEntity formFieldSet(FormFieldSetEntity formFieldSet) {
    this.formFieldSet = formFieldSet;
    return this;
  }

   /**
   * Get formFieldSet
   * @return formFieldSet
  **/
  @Schema(description = "")
  public FormFieldSetEntity getFormFieldSet() {
    return formFieldSet;
  }

  public void setFormFieldSet(FormFieldSetEntity formFieldSet) {
    this.formFieldSet = formFieldSet;
  }

  public BundleEntity id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Bundle ID
   * @return id
  **/
  @Schema(example = "1", description = "Bundle ID")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BundleEntity createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Bundle created at date/time
   * @return createdAt
  **/
  @Schema(description = "Bundle created at date/time")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public BundleEntity expiresAt(DateTime expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }

   /**
   * Bundle expiration date/time
   * @return expiresAt
  **/
  @Schema(description = "Bundle expiration date/time")
  public DateTime getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(DateTime expiresAt) {
    this.expiresAt = expiresAt;
  }

  public BundleEntity maxUses(Integer maxUses) {
    this.maxUses = maxUses;
    return this;
  }

   /**
   * Maximum number of times bundle can be accessed
   * @return maxUses
  **/
  @Schema(example = "1", description = "Maximum number of times bundle can be accessed")
  public Integer getMaxUses() {
    return maxUses;
  }

  public void setMaxUses(Integer maxUses) {
    this.maxUses = maxUses;
  }

  public BundleEntity note(String note) {
    this.note = note;
    return this;
  }

   /**
   * Bundle internal note
   * @return note
  **/
  @Schema(example = "The internal note on the bundle.", description = "Bundle internal note")
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public BundleEntity userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Bundle creator user ID
   * @return userId
  **/
  @Schema(example = "1", description = "Bundle creator user ID")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public BundleEntity username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Bundle creator username
   * @return username
  **/
  @Schema(example = "user", description = "Bundle creator username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public BundleEntity clickwrapId(Integer clickwrapId) {
    this.clickwrapId = clickwrapId;
    return this;
  }

   /**
   * ID of the clickwrap to use with this bundle.
   * @return clickwrapId
  **/
  @Schema(example = "1", description = "ID of the clickwrap to use with this bundle.")
  public Integer getClickwrapId() {
    return clickwrapId;
  }

  public void setClickwrapId(Integer clickwrapId) {
    this.clickwrapId = clickwrapId;
  }

  public BundleEntity inboxId(Integer inboxId) {
    this.inboxId = inboxId;
    return this;
  }

   /**
   * ID of the associated inbox, if available.
   * @return inboxId
  **/
  @Schema(example = "1", description = "ID of the associated inbox, if available.")
  public Integer getInboxId() {
    return inboxId;
  }

  public void setInboxId(Integer inboxId) {
    this.inboxId = inboxId;
  }

  public BundleEntity hasInbox(Boolean hasInbox) {
    this.hasInbox = hasInbox;
    return this;
  }

   /**
   * Does this bundle have an associated inbox?
   * @return hasInbox
  **/
  @Schema(example = "true", description = "Does this bundle have an associated inbox?")
  public Boolean isHasInbox() {
    return hasInbox;
  }

  public void setHasInbox(Boolean hasInbox) {
    this.hasInbox = hasInbox;
  }

  public BundleEntity paths(List<String> paths) {
    this.paths = paths;
    return this;
  }

  public BundleEntity addPathsItem(String pathsItem) {
    if (this.paths == null) {
      this.paths = new ArrayList<>();
    }
    this.paths.add(pathsItem);
    return this;
  }

   /**
   * A list of paths in this bundle
   * @return paths
  **/
  @Schema(example = "[\"file.txt\"]", description = "A list of paths in this bundle")
  public List<String> getPaths() {
    return paths;
  }

  public void setPaths(List<String> paths) {
    this.paths = paths;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BundleEntity bundleEntity = (BundleEntity) o;
    return Objects.equals(this.code, bundleEntity.code) &&
        Objects.equals(this.url, bundleEntity.url) &&
        Objects.equals(this.description, bundleEntity.description) &&
        Objects.equals(this.passwordProtected, bundleEntity.passwordProtected) &&
        Objects.equals(this.previewOnly, bundleEntity.previewOnly) &&
        Objects.equals(this.requireRegistration, bundleEntity.requireRegistration) &&
        Objects.equals(this.requireShareRecipient, bundleEntity.requireShareRecipient) &&
        Objects.equals(this.clickwrapBody, bundleEntity.clickwrapBody) &&
        Objects.equals(this.formFieldSet, bundleEntity.formFieldSet) &&
        Objects.equals(this.id, bundleEntity.id) &&
        Objects.equals(this.createdAt, bundleEntity.createdAt) &&
        Objects.equals(this.expiresAt, bundleEntity.expiresAt) &&
        Objects.equals(this.maxUses, bundleEntity.maxUses) &&
        Objects.equals(this.note, bundleEntity.note) &&
        Objects.equals(this.userId, bundleEntity.userId) &&
        Objects.equals(this.username, bundleEntity.username) &&
        Objects.equals(this.clickwrapId, bundleEntity.clickwrapId) &&
        Objects.equals(this.inboxId, bundleEntity.inboxId) &&
        Objects.equals(this.hasInbox, bundleEntity.hasInbox) &&
        Objects.equals(this.paths, bundleEntity.paths);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, url, description, passwordProtected, previewOnly, requireRegistration, requireShareRecipient, clickwrapBody, formFieldSet, id, createdAt, expiresAt, maxUses, note, userId, username, clickwrapId, inboxId, hasInbox, paths);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BundleEntity {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    passwordProtected: ").append(toIndentedString(passwordProtected)).append("\n");
    sb.append("    previewOnly: ").append(toIndentedString(previewOnly)).append("\n");
    sb.append("    requireRegistration: ").append(toIndentedString(requireRegistration)).append("\n");
    sb.append("    requireShareRecipient: ").append(toIndentedString(requireShareRecipient)).append("\n");
    sb.append("    clickwrapBody: ").append(toIndentedString(clickwrapBody)).append("\n");
    sb.append("    formFieldSet: ").append(toIndentedString(formFieldSet)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
    sb.append("    maxUses: ").append(toIndentedString(maxUses)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    clickwrapId: ").append(toIndentedString(clickwrapId)).append("\n");
    sb.append("    inboxId: ").append(toIndentedString(inboxId)).append("\n");
    sb.append("    hasInbox: ").append(toIndentedString(hasInbox)).append("\n");
    sb.append("    paths: ").append(toIndentedString(paths)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
