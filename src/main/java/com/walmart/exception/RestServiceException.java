package com.walmart.exception;

public class RestServiceException extends Exception
{

    private static final long serialVersionUID = 1997753363232807009L;

		public RestServiceException()
		{
		}

		public RestServiceException(String message)
		{
			super(message);
		}

		public RestServiceException(Throwable cause)
		{
			super(cause);
		}

		public RestServiceException(String message, Throwable cause)
		{
			super(message, cause);
		}

		public RestServiceException(String message, Throwable cause, 
                                           boolean enableSuppression, boolean writableStackTrace)
		{
			super(message, cause, enableSuppression, writableStackTrace);
		}

}