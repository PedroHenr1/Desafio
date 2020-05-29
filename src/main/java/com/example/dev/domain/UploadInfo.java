package com.example.dev.domain;

public class UploadInfo
{
	private String file_name;
	private String date_time;
	private String status;

	public UploadInfo(String file_name, String date_time, String status)
	{
		this.file_name = file_name;
		this.date_time = date_time;
		this.status = status;
	}
	
	public String getFile_name()
	{
		return file_name;
	}
	public void setFile_name(String file_name)
	{
		this.file_name = file_name;
	}


	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
}
