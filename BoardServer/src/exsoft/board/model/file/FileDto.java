package exsoft.board.model.file;

public class FileDto {
	private String fileId;
	private String volumeId;
	private String filePath;
	private String fileName;
	private String fileType;
	private String fileSize;
	
	public FileDto() {}

	public FileDto(String fileId, String volumeId, String filePath,
			String fileName, String fileType, String fileSize) {
		super();
		this.fileId = fileId;
		this.volumeId = volumeId;
		this.filePath = filePath;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getVolumeId() {
		return volumeId;
	}

	public void setVolumeId(String volumeId) {
		this.volumeId = volumeId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
}
